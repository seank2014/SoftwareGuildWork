$(document).ready(function () {
	//hide everything but main when page loads
    $("#akronInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
	
	
	//akron info 
	$('#akronButton').on('click', function(){ 
	$('#akronInfoDiv').show();
	$('#akronWeather').hide();
	});  
	
	//minneapolis info
	$('#minneapolisButton').on('click', function(){
	$('#minneapolisInfoDiv').show();
	$('#minneapolisWeather').hide();	
	});
	
	$('#louisvilleButton').on('click', function(){
		$('#louisvilleInfoDiv').show();
		$('#louisvilleWeather').hide();
	});
	 
	$('#akronWeatherButton').on('click', function(){
		$('#akronWeather').show();
	});
	
	$('#minneapolisWeatherButton').on('click', function(){
		$('#minneapolisWeather').show();	
	});
	
	$('#louisvilleWeatherButton').on('click',  function(){
		$('#louisvilleWeather').show();
	});
	 
	 $('tr').hover(function(){
		 
		$(this).css('background-color','WhiteSmoke');
		 $('th').css('background-color', 'AliceBlue');

		
	 },
				  function(){
		 $(this).css('background-color', '');
		 $('th').css('background-color', 'AliceBlue');
	 });
	 
	
});