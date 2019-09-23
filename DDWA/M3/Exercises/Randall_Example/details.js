var ds = new DataService();

$(document).ready(function(){
//alert('ready');	
	//alert(window.location.search);
	var urlParams = new URLSearchParams(window.location.search);
	console.log(urlParams.get('dvdId'));
	ds.getDvdById(urlParams.get('dvdId'), onSuccessGetDvd);
});

function onSuccessGetDvd(dvd){
	console.log(dvd);
	$('#title').text(dvd.title);
		$('#director').text(dvd.director);
		$('#year').text(dvd.releaseYear);
		$('#rating').text(dvd.rating);
	$('#notes').text(dvd.notes);

}