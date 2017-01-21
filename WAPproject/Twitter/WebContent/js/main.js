$(function() {
	$("#romance").click(function() {
		$.get('TwitterServlet', {
			category: 'Romance'
		})
		.done(function() { 
			$("#trendtable").hide();
			$("#twittertable").show();
			location.reload();
			} )
		.fail(function() { /* alert("Romance category fail") */} )
	});
	$("#comedy").click(function() {
		$.get('TwitterServlet', {
			category: 'comedy'
		})
		.done(function() {
			$("#trendtable").hide();
			$("#twittertable").show();
			location.reload();
		}  )
		.fail(function() { /* alert("Comedy category fail") */}  )
	});
	$("#scifiction").click(function() {
		$.get('TwitterServlet',{
			category: 'scifiction'
		})
		.done(function() { 
			$("#trendtable").hide();
			$("#twittertable").show();
			location.reload();
			}  )
		.fail(function() { } )
	});
	$("#sitcome").click(function() {
		$.get('TwitterServlet',{
			category: 'sitcome'
		})
		.done(function() { 
			$("#trendtable").hide();
			$("#twittertable").show();
			location.reload();
		} )
		.fail(function() { /* alert("sitcome category fail") */} )
	});
	$("#seetrends").click(function() {
		$.get("TwitterServlet", {
			category: 'seetrends'
		})
		.done(function() {
			$("#trendtable").show();
			$("#twittertable").hide();
			location.reload(); 
		} )
		.fail(function() { /* alert("seetrend category fail") */} )
	});
	
});