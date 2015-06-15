$(document).ready(function(){
	$("#submit").on("click", function(e){
		console.log("button clicked")
		e.preventDefault();
		var url = $("#sendTweet").attr("action");
		var data = $("#sendTweet").serializeArray();
		$.ajax({
			url: url,
			data: data
		}).done(function(response){
			$("#tweetList").append(response);
			$("#message").val("");
		});
	})
	
	$(".list-group-item").on("mouseenter", function(){
		console.log("mouse entered");
		$(this).addClass("activeLi");
	});
	$(".list-group-item").on("mouseleave", function(){
		console.log("mouse left")
		$(this).removeClass("activeLi");
	});
	
	$("#editBtn").on("click",function(){
		console.log("edit clicked");
		var glyph = $(".glyphicon").first();
		if(glyph.hasClass("glyph"))
		{
			$(".glyphicon").removeClass("glyph");
			$(".glyphicon").addClass("showglyph");
		}
		else
		{
			$(".glyphicon").removeClass("showglyph");
			$(".glyphicon").addClass("glyph");
		}
	});
	
	$(".glyphicon").on("click", function(){
		console.log("glyph clicked")
		var url = "http://localhost:8080/Struts2Twitter/delete.action";
		var li = $(this).closest("li");
		var data = li.text();
		console.log(data);
		$.ajax({
			url: url,
			data: {message2: data}
		}).done(function(){
			console.log("removing li");
			li.remove();
			console.log("li removed")
		});
		
	});
});

