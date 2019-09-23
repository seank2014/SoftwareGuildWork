$(document).ready(function () {
	//centered all h1 elements
    $('h1').addClass('text-center');
	
	//centered all h2 elements
	$('h2').addClass('text-center');
	
	//need to change class
	$('#myBannerHeading').addClass('page-header');
	
	//change text name
	$('#yellowHeading').text('Yellow Team')
	
	
	//change background of color of each team
	$('#orangeTeamList').css('background-color', 'orange');
	$('#redTeamList').css('background-color', 'red');
	$('#blueTeamList').css('background-color', 'blue');
	$('#yellowTeamList').css('background-color', 'yellow');
	

	// adding name to yellow team
	$('#yellowTeamList').append('<li>Josephn Banks</li>');
	$('#yellowTeamList').prepend('<li>Simone Jones</li>');
	
	//hiding 'Hide me'
	$('#oops').toggle();
	
	//remove footer place holder
	$('#footerPlaceholder').remove();
	
	//add info to footer
	$('#footer').append('<p>Sean King, email info</p>');
	$('#footer').css('font-familyf:', 'courier');
	$('#footer').css('font-size', '24px');

	
});