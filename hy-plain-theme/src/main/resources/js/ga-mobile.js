ConfluenceMobile.contentEventAggregator.on("displayed", function() {
  var trackingCode = document.getElementById("tracking-code").innerHTML;
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', trackingCode]);
  _gaq.push(['_trackPageview']);

  (function() {
      var ga = document.createElement('script');
      ga.type = 'text/javascript';
      ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0];
      s.parentNode.insertBefore(ga, s);
      console.log("GA inserted with code: "+trackingCode+" from ConfluenceMobile.");
  })();
});
