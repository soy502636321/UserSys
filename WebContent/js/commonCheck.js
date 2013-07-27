//Function：四个公用函数：判断非空，判断日期，判断数值，判断字符串长度
//FileName: check.js
//Example://在提交按钮中加 onclick="return checkNoNull()"
          //在录入框中加 onBlur="return checkDate(this)"
          //在录入框中加 onBlur="return checkNum(this,10,2)"
          //在录入框中加 onBlur="return checkStrLen(this,10,0)"
//Return:   true|false
//Note:  1.判断非空在按钮触发，判断日期和判断数值在输入框触发,
           //判断数值中的第一个参数this表示触发控件本身,第二个参数为数值总长度(不包括小数点),第三个参数为小数点位数,
           //当第三个参数为0时,等于：只能输入最长为第二个参数的整数，1：小于，2，大于
         //判断字符串长度，第三个参数为0表该值为第二个参数指定的定长，否则表该值不能超过第二个参数指定的长度

//判断非空,用id来判断
var checkNumArray=new Array();
function checkNoNull(warnMsg,obj){
var msg="不能为空！";
	if(warnMsg!=undefined){
		msg=warnMsg;
	}
checkNumArray.length=0;
var str="";
var splitOfCheck=" "+msg+" \n";
var j=1000;
var ob;
if(obj==null){
 ob = window.document.forms[0];
}else{
 ob = obj;
} 
var judgeControlList=ob.all; 
var hiddeninfoV="";
var hiddeninfolen=0;
if(document.getElementById("hiddeninfo")!=null)
{
hiddeninfolen=document.all("hiddeninfo").length;
if(hiddeninfolen!=undefined)
	{
		for(var w=0;w<hiddeninfolen;w++)
			{
			hiddeninfoV=hiddeninfoV+document.all("hiddeninfo")[w].value;//当一个页面里面有多个hiddeninfo的时候，该值返回的是undefined
			}
	}
else
	{
	hiddeninfoV=document.all("hiddeninfo").value;
	}
}
//alert(hiddeninfoV);
try{
//alert(hiddeninfoV+'---------0-----1---'+judgeControlList.length)
for (var i=0;i<judgeControlList.length;i++){
  var elv=judgeControlList[i].name;
  var isreadonly=false;
   //当是隐藏控件的时候，不进行判断
  if(hiddeninfoV!=undefined&&hiddeninfoV!=""&&(hiddeninfoV.indexOf(elv)!=-1||hiddeninfoV.indexOf(judgeControlList[i].id)!=-1))
  	continue;
  var k=judgeControlList[i].type;
  var mustInputLabel=judgeControlList[i].mustInput;
  //alert(k+"--"+elv);
  if(k=="text"|| k=="textarea"||k=="password"||k=="file"){	
  	if(mustInputLabel!=undefined&&mustInputLabel!=""&&judgeControlList[i].readOnly!=undefined&&judgeControlList[i].readOnly==true)
		{
    	isreadonly=true;
      }
  } else{
	  if(k=="select-one")
	  {
	    if(mustInputLabel!=undefined&&mustInputLabel!=""&&judgeControlList[i].innertitle!=undefined&&judgeControlList[i].onchange!=undefined)
	    isreadonly=true;
	  }
	  else
	  	if(k=="checkbox" || k=="radio")
	  	{
	  	
	  	if(mustInputLabel!=undefined&&mustInputLabel!=""&&judgeControlList[i].innertitle!=undefined&&judgeControlList[i].disabled!=undefined&&judgeControlList[i].disabled==true)
	    	isreadonly=true;
	  	}
}
/*释放该条件，让对只读的字段也进行判断*/
isreadonly=false;	  	

  if(!isreadonly&&(k=="text" || k=="select-one" || k=="textarea"||k=="password"||k=="file")){
        //当类型为输入框或下拉框时
    var eachvalue=RTrim(LTrim(judgeControlList[i].value));
    var mustInputLabelK=judgeControlList[i].mustInput;
      if(eachvalue=="" && mustInputLabelK!=undefined&&mustInputLabelK!="") {//当id不为空时并且值为空
          str=str+mustInputLabelK+splitOfCheck;
          if(j>i) j=i;
      }
    }
    if(!isreadonly&&(k=="checkbox" || k=="radio"))
    {//当类型为输入框或下拉框时
	
        var checkFlag=false;
        var checkFlag2=false;
        var elename=judgeControlList[i].name;
        for(var m=0;m<checkNumArray.length;m++)
        {
            if(checkNumArray[m]==elename)
            {
                checkFlag2=true;
                break;
            }
        }
        //当前的控件以前没有检测过
        if(checkFlag2==false)
        {
            checkNumArray[m]=elename;
            if(document.all[elename].length==null)
            {
            	var mustInputLabelOne=document.all[elename].mustInput;
                if(mustInputLabelOne!=undefined&&mustInputLabelOne=="" ||mustInputLabelOne==undefined|| document.all[elename].checked==true)
                {
                    checkFlag=true;
                }
            }
            else
            {
	                for(var l=0;l<document.all[elename].length;l++)
	                {
	                    var eachvalue2=document.all[elename][l].checked;
	                    var mustInputLabelTwo=document.all[elename][l].mustInput;
	                    //alert(mustInputLabelTwo);
	                    if(eachvalue2==true ||mustInputLabelTwo!=undefined&&mustInputLabelTwo==""||mustInputLabelTwo==undefined)
	                     {
	                        //alert("true!");
	                        checkFlag=true;
	                            break;
	                     }
	                }
            }
            if(checkFlag==false)
            {
                //alert("here");
                if(document.all[elename].length==null){
               	 	str=str+document.all[elename].mustInput+splitOfCheck;
                }
                else{
                	str=str+document.all[elename][0].mustInput+splitOfCheck;
                }
                if(j>i) {
                	j=i;
                }
            }
        }
      }

   }
if (str!="")//当所求字符串不为空时证明有必填字段为空
{
	//alert(str+"--"+judgeControlList[j].name);
   if(judgeControlList[j].readOnly==false&&judgeControlList[j].disabled==false){
   		if(judgeControlList[j].style.display=='none'){
   			judgeControlList[j].style.display='';
   		}
    	judgeControlList[j].focus();//当控件为隐藏的时候,光标定位不到,所以有可能会出现没有什么反应的情况,但是程序执行不下去
    }
    //alert(str+msg);
    alert(str);
    return false;
  }else{
       // return true;
	 return batchJudgeMaxLength();//对字符最大长度的校验，在checkObjectLen.js里面定义.
  }
  }catch(e)
      {
      alert(e);
      return;
  }
}

/*判断是否为大于0的数值*/
function checkNumMoreThanZero(Obj,s,f){
	if(numberMustMoreThanZero==undefined||numberMustMoreThanZero==""){
		numberMustMoreThanZero='输入的数值不能小于等于0';
	}
	if(checkNum(Obj,s,f)){
		var thisV=parseFloat(Obj.value);
		if(thisV<=0){
			Obj.select();
			alert(numberMustMoreThanZero);
			Obj.focus();
			return false;
		} else {
			return true;
		}
	} else {
		return false;
	}
}
/*判断输入的页码是否为大于0的数值：用在displayTag的分页手工输入的页面校验*/
function checkNumMoreThanZeroForPage(Obj,s,f){
	if(pageMustMoreThanZero==undefined||pageMustMoreThanZero==""){
		pageMustMoreThanZero='输入的页码必须大于0';
	}
	if(checkNum(Obj,s,f)){
		var thisV=parseFloat(Obj.value);
		if(thisV<=0){
			Obj.select();
			alert(pageMustMoreThanZero);
			Obj.focus();
			return false;
		} else {
			return true;
		}
	} else {
		return false;
	}
}

/*判断是否为大于等于0的数值*/
function checkNumMoreThanOrEqualsZero(Obj,s,f){
	if(numberMustNotLessZero==undefined||numberMustNotLessZero==""){
		numberMustNotLessZero='输入的数值不能小于0';
	}
	if(checkNum(Obj,s,f)){
		var thisV=parseFloat(Obj.value);
		if(thisV<0){
			Obj.select();
			alert(numberMustNotLessZero);
			return false;
		} else {
			return true;
		}
	} else {
		return false;
	}
}

/*判断是否为大于等于0的数值*/
function checkNumNotEqualsZero(Obj,s,f){
	if(numberMustNotEqualZero==undefined||numberMustNotEqualZero==""){
		numberMustNotEqualZero='输入的数值不能等于0';
	}
	if(checkNum(Obj,s,f)){
		var thisV=parseFloat(Obj.value);
		if(thisV==0){
			Obj.select();
			alert(numberMustNotEqualZero);
			return false;
		} else {
			return true;
		}
	} else {
		return false;
	}
}

//判断数值
function checkNum(Obj,s,f)
{
	if(inputMustNumeric==""){
		inputMustNumeric="请输入一个数值！";
	}
	if(inputError==""){
	inputError="输入错误,请重输!";
	}
	if(inputIntegralLessThanBefor==""){
		inputIntegralLessThanBefor="输入的 整数位 应小于";
	}
	if(inputDecimalLessThanBefore==""){
		inputDecimalLessThanBefore="输入的 小数位 应小于等于";
	}
	if(inputIntegralNOtMoreThan==""){
		inputIntegralNOtMoreThan="只能输入整数且小于";
	}
	if(inputNumberAfter==""){
		inputNumberAfter="位，请重输！";
	}
	var reg1=/,/g;
	var reg2=/，/g;
    var thisnum=Obj.value;
    if(thisnum=="") return true;
    var n=s-f;//整数位数
    var i;
    if(isNaN(thisnum)!=true)//当输入为数值
    {
      if(s!=-1)
      {
        if(f>0)
        {
            i=thisnum.indexOf(".");
            if(i==-1)//当找不到小数,可以输入整数
            {
                if(thisnum.length>n)
                {
                    Obj.select();
                    alert(inputIntegralLessThanBefor+n+inputNumberAfter);
                    return false;
                }
                else return true;
            }

            if(i==0 || i==thisnum.length-1)
            {
                Obj.select();
                alert(inputError);
                return false;
            }

            if(i>0)
            {
                var floatnum=thisnum.substr(i+1);//小数部分
                var plusnum=thisnum.length-floatnum.length-1;//整数部分
                if(plusnum>n)
                {
                    Obj.select();
                    alert(inputIntegralLessThanBefor+n+inputNumberAfter);
                    return false;
                }
                if (floatnum.length>f)
                {
                    Obj.select();
                    alert(inputDecimalLessThanBefore+f+inputNumberAfter);
                    return false;
                }
            }

        }

        if(f==0)
        {
            i=thisnum.indexOf(".");
            if(i!=-1)
            {
                Obj.select();
                alert(inputIntegralNOtMoreThan+n+inputNumberAfter);
                return false;
            }

            if(thisnum.length>n)
            {
                Obj.select();
                alert(inputIntegralNOtMoreThan+n+inputNumberAfter);
                return false;
            }
        }

      }
      return true;
    }
    else
    {
        Obj.select();
        alert(inputMustNumeric);
        return false;
    }

}



//判断日期
function checkDate(Obj,warnMsg)
{
	var msg="格式错误!\n正确的格式如：\n1900-01-01";
	if(warnMsg!=undefined){
		msg=warnMsg;
	}
    var thisdate=RTrim(LTrim(Obj.value));
    var reg = /^(\d{4})-(\d{2})-(\d{2})$/;//正则表达式
    var arr = reg.exec(thisdate);
    if(thisdate=="") return true;
    var success=true;
    if(reg.test(thisdate)&&RegExp.$1>=1900&&RegExp.$2<=12&&RegExp.$3<=31){
       
    	var splitS=thisdate.split("-");
    	var month=["04","06","09","11"]
    	var monthL=month.length;
    	for(var i=0;i<monthL;i++){
    		if(splitS[1]==month[i]&&splitS[2]=="31"){
    			success=false;
    			break;
    		}
    		//闰年的二月可以为29，否则只能为28
    		if(splitS[1]=="02"){
    			if(parseInt(splitS[0])%4==0){
    				if(splitS[2]>29){
    					success=false;
    				}
    			}else{
    				if(splitS[2]>28){
    					success=false;
    				}
    			}
    			if(!success){
	    			break;
    			}
    		}
    	}
    	if(!success){
    		alert(msg);
	        Obj.select();
	        return false;
    	}
    	return success;
    }else
    {
        alert(msg);
        Obj.select();
        return false;
    }
}

//判断日期
function checkTime(Obj,warnMsg)
{
	var msg="格式错误!\n正确的格式如：\n1900-01-01 00:00:00";
	if(warnMsg!=undefined){
		msg=warnMsg;
	}
	
    var thisdate=RTrim(LTrim(Obj.value));
    var reg = /^(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;//正则表达式
    var arr = reg.exec(thisdate);
    if(thisdate=="") return true;
    if(reg.test(thisdate)&&RegExp.$1>=1900&&RegExp.$2<=12&&RegExp.$3<=31&&RegExp.$4<=24&&RegExp.$5<=59&&RegExp.$6<=59){
       var splitS=thisdate.split(" ")[0].split("-");
    	var month=["04","06","09","11"]
    	var monthL=month.length;
    	for(var i=0;i<monthL;i++){
    		if(splitS[1]==month[i]&&splitS[2]=="31"){
    			success=false;
    			break;
    		}
    		//闰年的二月可以为29，否则只能为28
    		if(splitS[1]=="02"){
    			if(parseInt(splitS[0])%4==0){
    				if(splitS[2]>29){
    					success=false;
    				}
    			}else{
    				if(splitS[2]>28){
    					success=false;
    				}
    			}
    			if(!success){
	    			break;
    			}
    		}
    	}
    	if(!success){
    		alert(msg);
	        Obj.select();
	        return false;
    	}
    	return success;
    }else
    {
        alert(msg);
        Obj.select();
        return false;
    }
}

function checkNumAll(Obj,length)
{
    var thisdate=Obj.value
    var str="请输入小于"+length+"位的数字！";
    var reg = /^[+-]?[0-9]+\.?[0-9]+$/;//正则表达式
    var arr = reg.exec(thisdate);
    if(thisdate=="") return true;
    if(reg.test(thisdate))
    return true;
    else
    {
        alert(str);
        Obj.select();
        return false;
    }
}

//判断不超过9位数的整数
function checkInteger(obj, length, message){
	var objValue = obj.value;
	var str;
	if(objValue == "")return true;
	str = (message == null) ? "请输入小于"+length+"位的整数！" : message;
	var reg = /^[+-]?[1-9]\d{0,8}$/;
	var arr = reg.exec(objValue);
	if(reg.test(objValue)){
		return true;
	}else{
		alert(str);
		obj.select();
		return false;
	}
}

//判断字符串长度在两个值之间
function checkStrLenBetween(Obj,minLen,maxLen){
	var bigMin=checkStrLen(Obj,minLen,2);
	if(bigMin){
		return checkStrLen(Obj,maxLen,1);
	}else{
		return bigMin;
	}
}

//判断字符串长度
function checkStrLen(Obj,strLen,flag)
{
	if(fixedLengthOfcheckStrLen==""){
		fixedLengthOfcheckStrLen="该字符串只能为固定长度";
	}
	if(moreThanLengthOfcheckStrLen==""){
		moreThanLengthOfcheckStrLen="字符串长度必须大于";
	}
	if(notMoreThanLengthOfcheckStrLen==""){
		notMoreThanLengthOfcheckStrLen="字符串长度不能超过";
	}
	//alert(Obj.value)
    var str = new String(Obj.value);
    //alert(getByte(str)+'--'+strLen)
    if(str==""){
        return true;
    }
    else if (flag==0 && getByte(str) != strLen){
        alert(fixedLengthOfcheckStrLen+strLen);
        Obj.select();
        return false;
    }
    else if (flag==1&&getByte(str) > strLen)
    {
        alert(notMoreThanLengthOfcheckStrLen+strLen);
        Obj.select();
        return false;
    }
    else if (flag==2&&getByte(str) < strLen)
    {
        alert(moreThanLengthOfcheckStrLen+strLen);
        Obj.select();
        return false;
    }
    return true;
}


//checkNoNull()函数调用，本函数用于对sString字符串进行后空格截除
function RTrim(sString)
{
    var sStr,i,sResult = "",sTemp = "" ;

    // if (sString.length == 0) { return "" ;} // 参数sString是空串

    sStr = sString.split("");
    for (i = sStr.length - 1 ; i >= 0 ; i --)  // 将字符串进行倒序
    {
        sResult = sResult + sStr[i];
    }
    sTemp = LTrim(sResult) ; // 进行字符串前空格截除

    if (sTemp == "") { return "" ; }

    sStr = sTemp.split("");
    sResult = "" ;
    for (i = sStr.length - 1 ; i >= 0 ; i--) // 将经处理后的字符串再进行倒序
    {
        sResult = sResult + sStr[i];
    }
    return sResult ;
}

//checkNoNull()函数调用，本函数用于对sString字符串进行前空格截除
function LTrim(sString)
{
    var sStr,i,iStart,sResult = "";

    sStr = sString.split("");
    iStart = -1 ;
    for (i = 0 ; i < sStr.length ; i++)
    {
        if (sStr[i] != " ")
        {
            iStart = i;
            break;
        }
    }
    if (iStart == -1) { return "" ;}    //表示sString中的所有字符均是空格,则返回空串
    else { return sString.substring(iStart) ;}
}

//得到字符串的字节数，如：getByte("test测试")返回8
function getByte(s)
{
	var chinesesChar=2;
	if(isForOracle!=undefined||isForOracle!=null){
		if(isForOracle==true){
			chinesesChar=3;
		}
	}
    var intCount = 0;
    for(var i = 0;i < s.length;i ++)
    {
        // Ascii码大于255是双字节的字符
        if(s.charCodeAt(i) > 255)intCount += chinesesChar;
        else intCount += 1;
    }
    return intCount;
}
//改变某个控件的显示
function changeAction(obj,showOrHidden)
{
  var name=document.all(obj);
  if(name!=null){
  	if(showOrHidden==null||showOrHidden==undefined){
		  if(name.style.display=='none'){
		  	name.style.display='';
		  }else{
		  	name.style.display='none';
		  }
	 }else{
	 	if(showOrHidden){
	 		name.style.display='';
	 	}else{
	 		name.style.display='none';
	 	}
	 } 
  }
}

//某控件不显示,[通过名称来]
function nodisplay(obj)
{
  var name=document.all(obj);
  if(name!=null){
	  name.style.display='none';
  }
}

//让某控件显示【通过名称来】
function display(obj)
{
  var name=document.all(obj);
  if(name!=null){
    name.style.display='';
  }
}
  
//某控件不显示,[通过对象来]
function nodisplayByObj(obj)
{
  if(obj!=null){
    obj.style.display='none';
    }
  }

//让某控件显示【通过对象来】
function displayByObj(obj)
{
	if(obj!=null){
	  obj.style.display='';
	}
}

//改变某个控件的显示[通过对象来]
function changeActionByObj(obj)
{
 if(obj!=null){
    if(obj.style.display=='none'){
	  obj.style.display='';
	}else{
	  obj.style.display='none';
	}
  }
}
//让obj显示，并且移动到某个位置
function displaydiv(obj)
{
  var name=document.all(obj);
  if(name!=null){
	  name.style.display='';
	  movedivs(obj);
  }
}  
//移动层到光标所在位置的下面一点点
function movedivs(obj)
{
  var ys=window.event.y;
  var xs=window.event.x;
  var hes=5;
  document.all[obj].style.top=parseInt(ys+hes);

}
//将某些同样名称的radio的值赋给一个隐藏的控件，然后在后台得到该控件的值
//主要是为了流程定制而设置
function getradio(source,target)
{
	if(source!=null&&target!=null&&source.checked){
		document.all(target).value=source.value;
	}
}
//将某些同样名称的checkbox的值赋给一个隐藏的控件，然后在后台得到该控件的值
//主要是为了流程定制而设置
function getcheckbox(source,target)
{
var temp=document.all(target).value;
//alert(source.value+'----'+array[i].value)
	if(source.checked)
	{
	if(temp.indexOf(source.value)==-1)
	temp=temp+source.value+',';
	}
	else
	{
	if(temp.indexOf(source.value)!=-1)

	temp=temp.replace(source.value+',','');
	}

//if(temp=='')
//temp=' ';
document.all(target).value=temp;
//alert(document.all(target).value)
}


//该函数用来判断通过表单定制而生成的表单里面的textarea的控件内容是否超过数据库定义的字段的长度
//只对定制生成的表单有效
function checkTextArea()
{
var textareasize=1000;//表单定制里面的文本框、文本域的最大长度（和数据库字段长度是一样的），今后修改该值的时候也要修改contentoptions.js里面的sizearea
var designlen=64;//定制的表单里面的控件的名称一般是64或者96位（主要针对实例来说）
var textareastr="";
var textareaj=1000;
var ob=window.document.forms[0];
var hiddeninfoV="";
var hiddeninfolen=0;
if(document.getElementById("hiddeninfo")!=null)
{
hiddeninfolen=document.all("hiddeninfo").length;
if(hiddeninfolen!=undefined)
	{
		for(var w=0;w<hiddeninfolen;w++)
			{
			hiddeninfoV=hiddeninfoV+document.all("hiddeninfo")[w].value;//当一个页面里面有多个hiddeninfo的时候，该值返回的是undefined
			}
	}
else
	{
	hiddeninfoV=document.all("hiddeninfo").value;
	}
}
try{
	for (var i=0;i<judgeControlList.length;i++)
		{
		  var elv=judgeControlList[i].name;
		  if(hiddeninfoV!=undefined&&hiddeninfoV!=""&&hiddeninfoV.indexOf(elv)!=-1)
  			continue;
		  var k=judgeControlList[i].type;
		  var ctrol=judgeControlList[i];
		   //对文本域的字段长度进行限制的脚本
			if(k!="textarea")
				continue;
			else
				if(k=="textarea"&&elv.length>=designlen)
				{
					//var eachvalue=RTrim(LTrim(judgeControlList[i].value));//删除前后的空格
					var eachvalue=judgeControlList[i].value;//不删除前后的空格（免得正好在临界点的时候保存数据出错）
					if(getByte(eachvalue)>textareasize)
					{
					//得到控件的名称
					var pname=ctrol.parentElement.previousSibling;
					if(pname!=null)
					var pnames=pname.innerText.replace(":","").replace("：","");
					if(pnames=="")
					pnames=elv;
					textareastr=textareastr+pnames+",";
					if(textareaj>i) textareaj=i;
					}
					
				}
		}
	if (textareastr!="")
	{
	    judgeControlList[textareaj].focus();//当控件为隐藏的时候,光标定位不到,所以有可能会出现没有什么反应的情况,但是程序执行不下去
		judgeControlList[textareaj].select();
	    alert(textareastr+"长度不能超过"+textareasize+"个字节（"+(textareasize/2)+"个汉字）！");
	    return false;
	  }else{
	      return true;
	  }
  }catch(e)
  {
  		//alert(e)
      return;
  }	

}

function checkEmail(val,mailMsg)
{
  var msg="邮件格式错误，请重新输入！";
	if(mailMsg!=undefined){
		msg=mailMsg;
	}
	
  if(val!=null){
	  var value=val.value;
	  if(value!=""){
		  var mail=/^[_\.0-9a-z-]+@([0-9a-z-]){1,}/i; 
		  var endS=/(\.)[a-z]{2,3}$/i; 
		  if(!(mail.test(value)&&endS.test(value)))
		   {
		      alert(msg);
		      val.focus();
		      return false; 
		    }
		  else
		    {
			  return true;
		    }
	    }else{
	    	return true;
	    }
    }else{
	    return;
    }
}

function judgeMail(emailStr){
	if (emailStr.length == 0) {
              return true;
        }
        var emailPat=/^(.+)@(.+)$/;
        var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
        var validChars="\[^\\s" + specialChars + "\]";
        var quotedUser="(\"[^\"]*\")";
        var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
        var atom=validChars + '+';
        var word="(" + atom + "|" + quotedUser + ")";
        var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
        var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
        var matchArray=emailStr.match(emailPat);
        if (matchArray == null) {
            return false;
        }
        var user=matchArray[1];
        var domain=matchArray[2];
        if (user.match(userPat) == null) {
            return false;
        }
        var IPArray = domain.match(ipDomainPat);
        if (IPArray != null) {
            for (var i = 1; i <= 4; i++) {
               if (IPArray[i] > 255) {
                  return false;
               }
            }
            return true;
        }
        var domainArray=domain.match(domainPat);
        if (domainArray == null) {
            return false;
        }
        var atomPat=new RegExp(atom,"g");
        var domArr=domain.match(atomPat);
        var len=domArr.length;
        if ((domArr[domArr.length-1].length < 2) ||
            (domArr[domArr.length-1].length > 3)) {
            return false;
        }
        if (len < 2) {
            return false;
        }
        return true;
}

//splitStr()函数调用，本函数用于对sString字符串的豆号进行截除
function splitStr(sString){
    var i,sResult = "";         
    for (i = 0 ; i < sString.length ; i++){
    	var a=sString.substring(i, i+1);
        if ( a!= ",")        	
           sResult=sResult+a;
    } 
   return sResult;
}
//判断复选框有没有被选中
function checkCheckBox(selectIdP)
{
if(!selectIdP)
{//没有复选框的条件下
	return false;
}
 if(!selectIdP.length)
 {  
	 if(selectIdP.checked)
	 {
		 return true;		 
	 }
	 else
		 {
		 return false;
	 }
 }
 else{
	 for(var i=0;i<selectIdP.length;i++)
     {
      if(selectIdP[i].checked)
     {
			return true;
	   }
	 }

}
	 return false;   
}
//得到复选框的值的字符串
function getCheckBoxValue(selectIdP)
{
	var value="";
 if(!selectIdP.length)
 {
	 if(selectIdP.checked)
	 {
		 return selectIdP.value;
	 }
	 else
		 {
		 return "";
	 }
 }
 else{
	 for(var i=0;i<selectIdP.length;i++)
     {
      if(selectIdP[i].checked)
     {
			value=value+","+selectIdP[i].value;
	  }
	 }

}
 if(value=="")
 {
	 return "";
 }
 else
 {
	 return value.substring(1,value.length);

 }	
}
//得到复选框的值的字符串,将复选框的值根据splitS进行拆分，最后拆分到一个长度为2的数组里面
function getCheckBoxValueInto2Array(selectIdP,splitS)
{
   if(splitS==undefined||splitS==null){
   	return getCheckBoxValue(selectIdP);
   }else{
		var split1="";
		var split2="";
		 if(!selectIdP.length)
		 {
			 if(selectIdP.checked)
			 {
				 var midV=selectIdP.value.split(splitS);
				 split1=midV[0];
				 split2=midV[1];
			 }
			 
		 }
		 else{
			 for(var i=0;i<selectIdP.length;i++)
		     {
			      if(selectIdP[i].checked)
				     {
				     		var midV=selectIdP[i].value.split(splitS);
							split1=split1+","+midV[0];
							split2=split2+","+midV[1];
					  }
			 }
		
		}
		 if(split1!="")
			 {
				  split1=split1.substring(1,split1.length);
			 }	
		 if(split2!="")
			 {
				  split2=split2.substring(1,split2.length);
			 }
	var returnA=[];
	returnA[0]=split1;		 	
	returnA[1]=split2;	
	return returnA;	 	
	}	 
}
//通过checkbox的name的名称得到相同名称的被选中的checkbox的值
function getCheckboxValueByName(checkName){
	var checkO=document.getElementsByName(checkName);
	return getCheckBoxValue(checkO);
}

//将名称为checkBoxName的复选框选中【当它的值在judgeValue范围内的时候】
function makeCheckBoxChecked(checkBoxName,judgeValue){
	var checkO=document.getElementsByName(checkBoxName);
	if(checkO.length){
		var checkL=checkO.length;
			if(checkL>0){
			var midCon=judgeValue.split(",");
			var lens=midCon.length;
			for(var j=0;j<lens;j++){
				if(midCon[j]!=""){
					for(var i=0;i<checkL;i++){
						if(checkO[i].value==midCon[j]){
							checkO[i].checked=true;
						}
					}
				}
			}
		}
	}
}
//将名称为checkBoxName的复选框选中
function makeCheckBoxCheckedDefault(checkBoxName){
	var checkO=document.getElementsByName(checkBoxName);
	if(checkO.length){
		var checkL=checkO.length;
		if(checkL>0){
			for(var i=0;i<checkL;i++){
				checkO[i].checked=true;
			}
		}
	}	
}

//将checkbox的值全部不选中，清空。
function makeCheckBoxClear(checkBoxName){
	var checkO=document.getElementsByName(checkBoxName);
	if(checkO.length){
		var checkL=checkO.length;
		if(checkL>0){
			for(var i=0;i<checkL;i++){
				checkO[i].checked=false;
			}
		}
	}
}
//简单的判断一个输入框是否为空
function isNotNull(obj,objname,warnMsg){ 
	var msg="不能为空！";
	if(warnMsg!=undefined){
		msg=warnMsg;
	}
	if (obj!=null&&(obj.value==null||RTrim(LTrim(obj.value))=='')){
		alert(objname+msg);
		obj.focus();
		return false;
	}
	return true;
}

//得到时间的数字表示
function geDateIntValue(obj)
{   
	var startdate=RTrim(LTrim(obj.value));
    var str="格式错误!\n正确的格式如：\n1900-01-01";
    var reg = /^(\d{4})-(\d{2})-(\d{2})$/;//正则表达式
    var arr = reg.exec(startdate);
	var year = parseFloat(RegExp.$1)+"";
	var month = parseFloat(RegExp.$2)+"";
	var day = parseFloat(RegExp.$3)+"";
	var dateValue = year+month+day;
	return parseFloat(dateValue);	
}

//得到单选按钮的选择地值*/
 function getRadioValue(fieldName) {
 	var retV="";
//	 var fm = document.forms[0];
//        for( i=0 ; i<fm.elements.length ; i++) {
//	    if (fm.elements[i].name == fieldName) {
//	        if (fm.elements[i].checked == true&&fm.elements[i].type=="radio") {
//					retV=fm.elements[i].value;
//					break;
//	        }
//	    }
//	}
	var radioO = document.getElementsByName(fieldName);
	 if(radioO.length){
	 	var lens=radioO.length;
	 	for(var i=0;i<lens;i++){
	 		var midRadio=radioO[i];
	 		if(midRadio.checked==true&&midRadio.type=="radio"){
	 			retV=midRadio.value;
	 			break;
	 		}
	 	}
	 }else{
	 	retV=radioO.value;
	 }
	return retV;
}

//设置单选按钮的默认选择的值
 function makeRadioChecked(fieldName,fieldV) {  
 	
 	var radioO=document.getElementsByName(fieldName);
	if(radioO.length){
		var radioL=radioO.length;
		if(radioL>0){
			for(var i=0;i<radioL;i++){
				if(radioO[i].value==fieldV){
					radioO[i].checked=true;
				}
			}
		}
	}
}


//改变某个控件的显示
function changeActionBatch(obj,showOrHidden)
{
  var objO=document.all(obj);
  if(objO!=null){
	  var i=objO.length;
	  if(i!=undefined){
		  for(var j=0;j<i;j++){
		  	var midO=objO[j];
		  	if(showOrHidden==null||showOrHidden==undefined){
			    if(midO.style.display=='none'){
				  	midO.style.display='';
				  }
				  else{
				 	midO.style.display='none';
				  }
			  }else{
			  	if(showOrHidden){
			  		midO.style.display='';
			  	}else{
			  		midO.style.display='none';
			  	}
			  }
			}
		}
		else{
			changeAction(obj,showOrHidden);
		}
	}
  }

/*通过选择的下拉列表name1的选项，然后设置name2控件的值为name1的选项的text*/
 function setValueBySelText(name1,name2){
 	var wwa;
 	if(curForm!=null||curForm!=undefined){
 		wwa=curForm.all(name1);
 	}else{
 		wwa=document.all(name1);
 	}
 	if(wwa!=null&&wwa.type=="select-one"){
 		var sel=wwa.selectedIndex;
 		if(sel!=undefined&&sel!=-1){
	 		var texts=wwa.options[sel].text;
	 		var bezek=document.all(name2);
	 		if(bezek!=null){
	 			bezek.value=texts;
	 		}
 		}
 	}
 }
 
 /*判断2个控件里面的值是否相等.*/
 function validateTwoConIsSameV(objName1,objName2,errorMsg){
 	var msg="两个控件里面的值不等."
 	if(errorMsg!=undefined){
 		msg=errorMsg;
 	}
	//alert(objName1+'--'+objName2)
	var objName1O=document.all(objName1);
	var objName2O=document.all(objName2);
	//alert(objName1O.value+'--'+objName2O.value)
	if(objName1O!=null&&objName2O!=null){
		if(objName1O.value!=objName2O.value){
			alert(msg);
			return false;
		}
	}
	return true;
}


function judgeOneTimeBeforeAnother(firstName,anotherName,showMsg){
	var defaultMsg="开始时间不能早于结束时间";
	var msg="";
	if(showMsg==null){
		msg=defaultMsg;
	}else{
		msg=showMsg;
	}
	var firstOne=document.all(firstName);
	var anotherOne=document.all(anotherName);
	if(firstOne!=null&&anotherOne!=null){
		if(firstOne.value>anotherOne.value&&(firstOne.value!=""&&anotherOne.value!="")){
			alert(msg);
			return false;
		}
	}
	return true;
}


/*电话号码的验证

要求：
　　(1)电话号码由数字、"("、")"和"-"构成
　　(2)电话号码为3到8位
　　(3)如果电话号码中包含有区号，那么区号为三位或四位
　　(4)区号用"("、")"或"-"和其他部分隔开
　　(5)移动电话号码为11或12位，如果为12位,那么第一位为0
　　(6)11位移动电话号码的第一位和第二位为"13"
　　(7)12位移动电话号码的第二位和第三位为"13"
　　根据这几条规则，可以与出以下正则表达式：
　　(^[0-9]{3,4}-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^([0-9]{3,4})[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)

*/
function checkPhone(obj,showMsg) {
	if(obj==null||obj==undefined){
		return true;
	}
	var val=obj.value;
	if(val==""){
		return true;
	}
	var msg="输入的电话号码不合法，请重新输入";
	if(showMsg!=undefined){
		msg=showMsg;
	}
	if(val!=null){	
		 //var reg=/(^[0-9]{3,4}-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^([0-9]{3,4})[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
		 //if(!reg.test(val)){
		 if(!checkNumAfterReplace(val)){	
		 	alert(msg);
		 	obj.focus();
		 	return false;
		 }else{
		 	return true;
		 }
	 }
	 return true;
}
/*将val里面的特殊字符替换掉，看看剩下的是不是全部是数字*/
function checkNumAfterReplace(val){
	if(val!=null){
		var reg1=/\-/g;
		var reg2=/\(/g;
		var reg3=/\)/g;
		var reg4=/ /g;
		var midS=val.replace(reg1,"").replace(reg2,"").replace(reg3,"").replace(reg4,"");
		//alert('--'+midS+'--'+!isNaN(midS));
		if(midS==""){
			return true;
		}
		return !isNaN(midS);
	}
	return true;
}


/*
	将一个复选框checkboxName里面的值设置给某个otherName控件:将checkbox选中的值设置给otherName控件
	
*/

function setCheckBoxValueToOther(checkboxName,otherName){

	var otherO=document.all(otherName);
	var checkBoxO=document.all(checkboxName);
	if(otherO!=null&&checkBoxO!=null){
		var str=getCheckboxValueByName(checkboxName);
		otherO.value=str;
	}
	
}
/*
	用otherName控件的值来设置checkboxName的值选中：当checkboxName的值在otherName的值里面的时候，则选中。
	
*/
function makeCheckboxCheckedUsedOtherValue(checkboxName,otherName){

	var otherO=document.all(otherName);
	var checkBoxO=document.all(checkboxName);
	if(otherO!=null&&checkBoxO!=null){
		makeCheckBoxChecked(checkboxName,otherO.value);
	}
	
}


/*
校验控件的值不能超过judgeNumber
*/
function judgeObjecctValueNotMoreThanNumber(objName,judgeNumber,showMsg){
	var objO=document.getElementsByName(objName);
	if(objO!=null&&objO.length!=0){
		var lens=objO.length;
		var totalValue=0;
		for(var i=0;i<lens;i++){
			var objV=objO[i].value;
			totalValue=parseFloat(totalValue)+parseFloat(objV);
		}
		if(parseFloat(totalValue)>parseFloat(judgeNumber)){
			if(showMsg==null||showMsg==undefined){
				showMsg=objName+"总和不能大于"+judgeNumber;
			}
			alert(showMsg);
			return false;
		}
	}
	return true;
}

/*
校验是否以"ambow.com"为结尾的邮箱，并获取用户名
*/
function checkEmailIDS(val,mailMsg){
  var mailIsRight="";
  var mailIsRight2="";
  var mailStr=val.value;
  if(mailStr==null||mailStr==""){
  	mailIsRight=false;
  }else{
  	mailIsRight=true;
  	if(checkEmail(val,mailMsg)){
  	   mailIsRight2=true;
  	}else{
  	   mailIsRight2=false;
  	}
  }
  if(mailIsRight){
    if(mailIsRight2){
       var emailList=mailStr.split("@");
  	   /*
  	   if(emailList[1]!="ambow.com"||emailList[0]==""||emailList[0]==null) {
          alert(mailMsg);
          val.focus();
          return false;
	   }else if(emailList[1]=="ambow.com"&&emailList[0]!=""&&emailList[0]!=null){
          return emailList[0];
	   }
	   */
	   return emailList[0];
    }else{
  	   val.focus();
  	   return false;
    }
  }
  return false;
}

Math.hold = function(x,n)		//对计算结果四舍五入
{
    var N = Math.pow(10,n);
    return Math.round(x * N)/N;
}

function checkRete(obj, len, msg){	//控制只能输入0-1之间，最多只有两位小数的数字
	if(obj.value == "")return true;
	var myregexp = /^[0](\.[0-9]{1,2})?|^[1](\.[0]{1,2})?$/;
	if(!myregexp.test(obj.value)){
		if(msg == undefined || msg == ""){
			alert("输入的数字必须为0至1之间，且最多只有两位小数的数字。");
		}else{
			alert("<bean:message key='errors.reteError'/>");
		}
		obj.select();
		return false;
	}else{
		if(obj.value > 1 || obj.value < 0){
			if(msg == undefined || msg == ""){
				alert("输入的数字必须为0至1之间，且最多只有两位小数的数字。");
			}else{
				alert("<bean:message key='errors.reteError'/>");
			}
			obj.select();
			return false;
		}else if( obj.value.length - (obj.value.lastIndexOf(".")+1) > len){
			if(msg == undefined || msg == ""){
				alert("输入的数字必须为0至1之间，且最多只有两位小数的数字。");
			}else{
				alert("<bean:message key='errors.reteError'/>");
			}
			obj.select();
			return false;
		}else{
			return true;
		}
	}
}




function replaceAll(object, target, instead){ 
	return object.replace(new RegExp(target,"gm"), instead);    
}
//对销售单的销售日期、服务开始日期、产品送达日期，退货的退货日期，收款的收款日期、付款的付款时间等要做如下校验：
//
//	1 当当前日期大于等于系统参数表里面的statisticsDate的值的时候，则这个字段的值不能设置为当月对应日期之前的所有日期.
//
//	2 当当前日期小于系统参数表里面的statisticsDate的时候，不能设置早于上个月1号的数据.
//
function checkStatisticsDate(obj, curDate, statisDate, msg){
	if(obj.value != "" && nowDate != "" && statisticsDate != ""){
		var midCurDate = "";
		var midStatisDate = "";
		var midMsg = "";
		midCurDate = (curDate == undefined) ? nowDate : curDate;
		midStatisDate = (statisDate == undefined) ? statisticsDate : statisDate;
		midMsg = (msg == undefined) ? checkStatisticsMsg : msg;
		var objValue = obj.value;
		var tokens = midCurDate.split("-");
		if(tokens.length < 3)return false;
		if(parseInt(tokens[2]) > parseInt(midStatisDate)){
		 	var dateOne = tokens[0] + "-" + tokens[1] + "-" + "01";
		 	if(parseInt(replaceAll(dateOne, "-", "")) > parseInt(replaceAll(objValue, "-", ""))){
		 		if(midMsg == "" || midMsg == undefined){
		 			alert("上月的汇总时间已过，您输入的日期必须晚于"+dateOne+" 00:00:00");
		 		}else{
		 			alert(midMsg+dateOne+" 00:00:00");
		 		}
		 		obj.select();
		 		return false;
		 	}
		 }else{
		 	var month = parseInt(tokens[1] - 1);	//计算上一个月的月份
		 	if(month < 10)month = "0" + month.toString();
		 	if(month == 0){							//如果是一月份，则年份为当前年份减一，月份为十二
		 		month = 12;
		 		tokens[0] = parseInt(tokens[0] - 1);
		 	}
		 	var dateTwo = tokens[0] + "-" + month + "-" + "01";
		 	if(dateTwo > obj.value){
		 		if(midMsg == "" || midMsg == undefined){
		 			alert("上月的汇总时间已过，您输入的日期必须晚于"+dateTwo+" 00:00:00");
		 		}else{
		 			alert(midMsg+dateTwo+" 00:00:00");
		 		}
		 		obj.select();
		 		return false;
		 	}
		 }
		return true;
	}else{
		return true;
	}
}

