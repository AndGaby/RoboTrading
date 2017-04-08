$(document).ready(function() {
	$('#summernote').summernote({
		height: 300
	});
});

var editarTexto = function() {
	$('#summernote').summernote({
		focus : true,
		height: 300
	});
};

var mostrarTexto = function() {
	var makrup = $('#summernote').summernote('code');
	$('#summernote').summernote('destroy');
};