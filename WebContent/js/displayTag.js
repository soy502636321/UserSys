/*
@note：jumpToOfDisplayTag,pageOfDisplayTag,
searchOfDisplayTag，basePathOfJs 在public.jspf里面定义
*/

/*
该js里面放的主要是针对displayTag标签库的相关操作.
author:elegant 2007-08-23
*/

/*将displayTag的列链接加到行上的操作*/
function addHrefLinkToTr(objTd){
	if(objTd!=null){
		var parentO=objTd.parentNode;
		while(parentO.tagName!="TR"){
			parentO=parentO.parentNode;
		}
		parentO.onclick=objTd.onclick;
	}
}

/*
循环整个displayTag的tab，将第一行、最后一行以外的tr的点击事件设置为pos位置的第一个控件的点击事件
pos的位置是从0开始计算的。
*/

function addHrefToTrByPosition(tableName,pos){
	var tableO=document.all(tableName);
	if(tableO!=null){
		var rowL=tableO.rows.length;
		for(var i=1;i<rowL-1;i++){
			var midTR=tableO.rows[i];
			var TDO=midTR.childNodes[pos];
			if(TDO!=null){
				var midObj=TDO.childNodes[0];
				if(midObj!=null&&midObj.tagName=="A"){
					if(midObj.onclick!=null){//直接是 href="#" onclick=的方式的时候
						midTR.ondblclick=midObj.onclick;
					}else{//当是href="a.jsp"的格式的时候，新增一个隐藏列，然后调用隐藏控件的点击事件
						var appendS="onclick=\"window.location='"+midObj.href+"';\" ";
						var appendIn="<input type=\"hidden\" "+appendS+" >";
						var cell=midTR.insertCell(0);
						cell.style.display='none';
						cell.innerHTML=appendIn;
						midTR.ondblclick=cell.childNodes[0].onclick;
					}
				}
			}
		}
	}
}

/*
在查询页面分页信息的最后加上一个输入框，可以用来输入数字，然后跳转到相应的页数。
@note:对displayTag的table的最后一行进行处理
@note:tableName 当前页面displayTag的table名
@note infoAlign:排序是居左还是居右
*/
var splitSOfDIPS="&";
var sortName="sort";
var dirName="dir";
var pageName="page";
var sortOfDISP=sortName+"=";
var dirOfDISP=dirName+"=";
var pageSOfDIPS=pageName+"=";
var pagePreOfDIPS=splitSOfDIPS+pageSOfDIPS;
var queryPageFisrtLoadS="queryPageFirstLoad=true";

function addSearchInputToTheEndOfPageInfo(tableName,infoAlign){
	if(infoAlign==null){
		infoAlign="";
	}
	var tableO=document.all(tableName);
	if(tableO!=null){
		var rowL=tableO.rows.length;
		var midTR=tableO.rows[rowL-1];
		
		
		//设置居左还是居右
		var midTd=midTR.cells(0);
		if(infoAlign!=""){
			midTd.align=infoAlign;
			if(midTd.childNodes[0]!=null){
				midTd.childNodes[0].align=infoAlign;
			}
		}
		//alert(midTd.outerHTML)
		
		var inputUrl="";//新添加的内容要执行的操作
		var spanA=midTR.getElementsByTagName("SPAN");
		var lastSpan;//需要添加新控件的span的位置
		if(spanA!=null){
			var spanLen=spanA.length;
			if(spanLen!=0){
				lastSpan=spanA[spanLen-1];
			}
		}
		if(lastSpan!=null){
			var hrefA=midTR.getElementsByTagName("A");
			if(hrefA!=null){
				var hrefLen=hrefA.length;
				if(hrefLen!=0){
					inputUrl=hrefA[0].href;
				}
			}
			//对inputUrl进行处理，将原始的page去掉,displayTag的&已经被解析为：&amp;
			
			
			inputUrl=removePageInfoFromUrl(inputUrl);
			
			var hrefName="hrefOfAppendSearch";

			var appendInner=" "+jumpToOfDisplayTag+"<input class='smallInput' type='text' name='searchInputOfDISP'"+
				" onblur=\"return checkNumMoreThanZeroForPage(this,8,0)&&setPageOfInputUrl(this.value,'"+hrefName+"');\" >"+
				pageOfDisplayTag+
				"<A name='"+hrefName+"' href='"+inputUrl+"'>"+" "+searchOfDisplayTag+" "+"</A>";
				//alert(appendInner);
			lastSpan.innerHTML=lastSpan.innerHTML+appendInner;
		}
		
	}
	addSortInfoToPageLinkHref(tableName);
}
/*
在hrefName的链接后面加上page=pageSize
重新构建它的要跳转的页数.
*/
function setPageOfInputUrl(pageSize,hrefName){
	var hrefO=document.getElementsByName(hrefName);
	if(hrefO!=null){
		var hrefLen=hrefO.length;
		for(var i=0;i<hrefLen;i++){
			var oldUrl=hrefO[i].href;
			var newUrl=removePageInfoFromUrl(oldUrl);
			hrefO[i].href=newUrl+pagePreOfDIPS+pageSize;
			//alert(hrefO[i].href+'-----');
		}
	}
	
	return true;
}

/*
重构超链接的url，将page的信息从url里面去掉.
*/
function removePageInfoFromUrl(hrefUrl){
	
	//首先去掉端口等附加信息.
	var reg=new RegExp(basePathOfJs,"g");
	hrefUrl=hrefUrl.replace(reg,"");
	//alert(hrefUrl)
	var inputArray=hrefUrl.split(splitSOfDIPS);
	hrefUrl="";
	if(inputArray!=null){
		var inputLen=inputArray.length;
		for(var i=0;i<inputLen;i++){
			var midS=inputArray[i];
			if(midS.indexOf(pageSOfDIPS)==0){
				continue;
			}else{
				if(i==0){
					hrefUrl+=midS;
				}else{
					hrefUrl+=splitSOfDIPS+midS;
				}
			}
		}
	}
	return hrefUrl;
}


/*
判断分页的链接里面是否包含了排序的信息，如果没包含的话，加上去
@note 当修改完记录之后，重现返回到用户进入该记录之前的查询页面的时候，因为displayTag的排序信息是在点击排序
的时候才加上的，所以当没有显式点击排序的时候，分页的信息上面不会包含排序的信息，此时需要手工加上
*/

function addSortInfoToPageLinkHref(tableName){
	
	var tableO=document.all(tableName);
	if(tableO!=null){
		var rowL=tableO.rows.length;
		var midTR=tableO.rows[rowL-1];

		var spanA=midTR.getElementsByTagName("SPAN");
		var lastSpan;//需要添加新控件的span的位置
		if(spanA!=null){
			var spanLen=spanA.length;
			if(spanLen!=0){
				lastSpan=spanA[spanLen-1];
			}
		}
		if(lastSpan!=null){
			var hrefA=midTR.getElementsByTagName("A");
			if(hrefA!=null){
				var hrefLen=hrefA.length;
				//alert(hrefLen)
				for(var i=0;i<hrefLen;i++){
					addSortInfoToPageLinkHrefSingle(hrefA[i]);
				}
			}
			
		}
		
	}
}

/*
单个的判断分页的链接是否有排序的信息，没有的话，加上.
*/
function addSortInfoToPageLinkHrefSingle(hrefO){
	
	var sortObject=document.all(sortName);
	var dirObject=document.all(dirName);
	if(sortObject!=null&&dirObject!=null&&hrefO!=null){
		var hrefUrl=hrefO.href;
		//首先去掉端口等附加信息.
		var reg=new RegExp(basePathOfJs,"g");
		hrefUrl=hrefUrl.replace(reg,"");
		//alert(hrefUrl)
		var inputArray=hrefUrl.split(splitSOfDIPS);
		var existSort=false;
		var existDir=false;
		if(inputArray!=null){
			var inputLen=inputArray.length;
			for(var i=0;i<inputLen;i++){
				var midS=inputArray[i];
				if(!existSort&&midS.indexOf(sortOfDISP)==0){
					existSort=true;
				}
				if(!existDir&&midS.indexOf(dirOfDISP)==0){
					existDir=true;
				}
				if(existSort&&existDir){
					break;
				}
			}
			if(!existSort){
				hrefUrl+=splitSOfDIPS+sortOfDISP+sortObject.value;
			}
			if(!existDir){
				hrefUrl+=splitSOfDIPS+dirOfDISP+dirObject.value;
			}
			if(hrefUrl.indexOf(queryPageFisrtLoadS)==-1){
				hrefUrl+=splitSOfDIPS+queryPageFisrtLoadS
			}
			//alert(hrefUrl)
			hrefO.href=hrefUrl;
		}
	}

}
/*
当点击search的时候，清空当前页面的信息，否则会出现当前是第五页，但是查询的结果不足一页，就显示不出来的bug.
*/
function clearPageSizeWhenSearch(){
	var pageObject=document.all(pageName);
	if(pageObject!=null){
		pageObject.value="";
	}
}