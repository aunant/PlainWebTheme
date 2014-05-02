AJS.toInit(function ($) {
    console.log("Fixing scrollbar");
    var mod_elements = document.getElementsByClassName('ia-scrollable-section');
    for (var i = 0; i < mod_elements.length; ++i) {
	var item = mod_elements[i];
	if (hasClass(item,'acs-side-bar'))
	    removeClass(item,'ia-scrollable-section');
    }
    function hasClass(ele,cls) {
	console.log("Fixing scrollbar, hasClass: "+cls);
	return ele.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'));
    }
    function removeClass(ele,cls) {
	console.log("Fixing scrollbar, removeClass: "+cls);
        if (hasClass(ele,cls)) {
            var reg = new RegExp('(\\s|^)'+cls+'(\\s|$)');
            ele.className=ele.className.replace(reg,' ');
        }
    }
});
