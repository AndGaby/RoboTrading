function edit() {
	$('.click2edit').summernote({
		focus : true
	});
};

function save() {
	var makrup = $('.click2edit').summernote('code');
	$('.click2edit').summernote('destroy');
};

console.log("teste")