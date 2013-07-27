function winOpen1(src,height,width){
	var sFeatures = "dialogHeight:"+height+"px;dialogWidth:"+width+"px;resizable:no;help:no;status:no;scroll:no;";
	var result = window.showModalDialog(src, window, sFeatures);
	return result;

}
function winOpen(sName, sUrl,iWidth,iHeight,bCentre) {
	var sFeatures;
	var iTop,iLeft;
        iWidth = iWidth + 20;
	if(bCentre!=true) {
		iTop=0;
		iLeft=0;
	}
	else {
		iTop=(screen.availHeight-iHeight)/2;
		iLeft=(screen.availWidth-iWidth)/2;
		//iTop=(screen.height-iHeight)/2;
		//iLeft=(screen.width-iWidth)/2;
	}
	sFeatures="height="+ iHeight +",width=" + iWidth +",top=" + iTop +",left=" + iLeft +",status=no, toolbar=no, menubar=no, location=no, resizable=no, scrollbars=yes";
	var objWin;
	objWin = window.open(sUrl, sName, sFeatures, "true");
	objWin.focus();
	return objWin;
}
function changeCheckBoxAll(obj,keys){
	nodes = document.getElementsByName(keys);
	for(var i=0;i<nodes.length;i++){
		nodes[i].checked = obj.checked;
	}
}
function changeCheckBoxStatus(objCb, bStatus) {
	if ( objCb == null ) return;
	if ( objCb.length != null ) {
		for ( var i = 0; i < objCb.length; i++ ) {
			objCb[i].checked = bStatus;
		}
	} else {
		objCb.checked = bStatus;
	}
}
function changeCheckBox(objCbChild, objCbParent) {
	if ( objCbChild.length != null ) {
		for ( var i = 0; i < objCbChild.length; i++ ) {
			if ( !objCbChild[i].checked ) {
				objCbParent.checked = false;
				return;
			}
		}
		objCbParent.checked = true;
	} else {
		objCbParent.checked = objCbChild.checked;
	}

}
function getCbValue(objCb, nStatus) {
	//nStatus, -1 means unchecked, 0 means all, 1 means checked
	if ( objCb == null ) return "";
	var strVal = "";	
	if ( objCb.length != null ) {
		switch ( nStatus ) {
			case -1:
				for ( var i = 0; i < objCb.length; i++ ) {
					if ( !objCb[i].checked ) {
						strVal += objCb[i].value + ",";
					}
				}
			break;

			case 0:
				for ( var i = 0; i < objCb.length; i++ ) {
					strVal += objCb[i].value + ",";
				}
			break;

			case 1:
				for ( var i = 0; i < objCb.length; i++ ) {				
					if ( objCb[i].checked ) {
						strVal += objCb[i].value + ",";
					}
				}
			break;
			
			default:
				for ( var i = 0; i < objCb.length; i++ ) {
					if ( objCb[i].checked ) {
						strVal += objCb[i].value + ",";
					}
				}
			break;
		}
		if ( strVal.length > 0 ) strVal = strVal.substr(0, strVal.length - 1);
	} else {	
		switch ( nStatus ) {
			case -1:
				if ( !objCb.checked ) strVal = objCb.value;
			break;
			case 0:
				strVal = objCb.value;
			break;
			case 1:
				if (objCb.checked ) strVal =  objCb.value;
				break;
			default:
				if ( objCb.checked ) strVal =  objCb.value;
			break;
		}
	}
//alert(strVal);
	return strVal;
}
function addOption(objSel, strValue, strText) {
	var objOption = document.createElement("OPTION");
	objOption.text = strText;
	objOption.value = strValue;
	objSel.add(objOption);
}
function removeOption(objSel, strVal) {
    for ( var i = 0; i < objSel.length; i++ ) {
        if ( objSel.item(i).value == strVal ) {
            objSel.remove(i);
        }
    }
}



//得到默认选中的值
function getDefaultCheckValue(){
	return getCheckValue("cbId");
}


//得到选中的值
function getCheckValue(checkboxName){
	var strVal = "";
	var objCb = document.all(checkboxName);
	if ( objCb == null ) return "";
	if ( objCb.length != null ) {
		for ( var i = 0; i < objCb.length; i++ ) {
			if (objCb[i].checked) {
				strVal += objCb[i].value + ",";
			}
		}
		if(strVal.length>0){
			strVal = strVal.substring(0, strVal.length-1);   
		}
	}
	return strVal;

}

			
//默认单选框
function singleSelect(){
	return singleSelectCheckBox("cbId");
}

//默认至少选择一个
function moreSelect(){
	return moreSelectCheckBox("cbId");
}


//判断复选框只能单选 
function singleSelectCheckBox(checkboxName){
    var strIds = getCbValue(document.all(checkboxName), 1);
    if ( strIds == "" ) {
    	alert("请选择一条记录！");
    	return false;
    }
	if ( strIds.indexOf(",") != -1 ) {
		alert("There is noly one record can be selected at a time!");
		return false;
	}
	return true;
}


//必须至少选择一个复选框
function moreSelectCheckBox(checkboxName){
	var strIds = getCbValue(document.all(checkboxName), 1);
    if ( strIds == "" ) {
    	alert("请至少选择一条记录！");
    	return false;
    }
    return true;
}




/*当回车事件触发时候要执行的操作，objName：表示要执行的操作*/
function onEnterPressKeyDown(eventE,objName){
	if (eventE.keyCode==13) {
		if(document.all(objName)!=null){
			document.all(objName).click();
		}
	}
	
}

/*打开showModel窗口使用*/
function windowOpenShowModel(obj,width,height){
    var dialogWidth="dialogWidth:800px;";
    var dialogHeight="dialogHeight:600px";
    if(width!=undefined&&width!=""){
        dialogWidth="dialogWidth:"+width+"px;";
    }
    if(height!=undefined&&height!=""){
        dialogHeight="dialogHeight:"+height+"px;";
    }
   return window.showModalDialog("jsp/showModelCommonFrame.jsp?distinctUrlObject="+obj,window,dialogWidth+ dialogHeight);
}