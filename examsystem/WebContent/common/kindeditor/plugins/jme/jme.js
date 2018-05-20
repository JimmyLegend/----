KindEditor.plugin('jme', function(e){
	var self = this, name = 'jme';
    self.clickToolbar(name, function() {
    	var dialog = self.createDialog({
    		title : '公式',
	        width : 400,
	        height : 400,
	        body : '<div style="width:400px;height:400px;">' +
	        	'<iframe id="math_frame" style="width:400px;height:400px;" frameborder="no" src="' 
	        	+ KindEditor.basePath + 'plugins/jme/dialogs/mathdialog.html"></iframe></div>',
	        yesBtn : {
                name : '确定',
                click : function(e) {
	        		var thedoc = document.frames ? document.frames('math_frame').document : getIFrameDOM("math_frame");
		        	var mathHTML = '<span class="mathquill-rendered-math" style="font-size:' 
		        		+ '20px' + ';" >' + $("#jme-math",thedoc).html() + '</span><span>&nbsp;</span>';
		        	
		        	self.insertHtml(mathHTML).hideDialog().focus();
		        	return;		        	
                }
	        }
    	});
    });
});

function getIFrameDOM(fid){
	var fm = getIFrame(fid);
	return fm.document||fm.contentDocument;
}
function getIFrame(fid){
	return document.getElementById(fid)||document.frames[fid];
}