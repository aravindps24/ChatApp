<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <h1>Welcome to my parent page</h1>
    <!-- loader script -->
    
	<script src="https://lex-web-ui-codebuilddeploy-xkvhovu1l-webappbucket-l2d92enb4unl.s3.amazonaws.com/lex-web-ui-loader.min.js"></script>
	<script>
	  var loaderOpts = {
		baseUrl: 'https://lex-web-ui-codebuilddeploy-xkvhovu1l-webappbucket-l2d92enb4unl.s3.amazonaws.com/',
		configUrl: 'https://lex-web-ui-codebuilddeploy-xkvhovu1l-webappbucket-l2d92enb4unl.s3.amazonaws.com/lex-web-ui-loader-config.json',
		iframeSrcPath: 'https://lex-web-ui-codebuilddeploy-xkvhovu1l-webappbucket-l2d92enb4unl.s3.amazonaws.com/index.html#/?lexWebUiEmbed=true'
		//shouldIgnoreConfigWhenEmbedded: true,
		//shouldLoadConfigFromJsonFile: true,
		//shouldLoadMinDeps: false
		
	  };
	  var loader = new ChatBotUiLoader.IframeLoader(loaderOpts);
	  loader.load()
		.catch(function (error) 
		{ 
			console.error(error); 
		});
	</script>
  
  </body>
</html>
