/**
 * 
 */

$(function(){
	var library = queryParameter('library');
	$.get('/overdue/rest/data/report/' + library, function(data, status){
		for (i in data){
			$('#overdue_table_body').append('<tr id="' + data[i] + '"></tr>\n');
		}
		for (x in data){
			createPresentation(data[x], library);
		}
	});

});

function createPresentation(barcode, library){
	$.get('/overdue/rest/data/presentation/' + library + '/' + barcode, function(presentation, status){
		$('#' + barcode)
		.append('<td class="col-sm-7">' + presentation[0] + '</td>' +
				'<td class="col-sm-1 ' + presentation[2] + '">' + presentation[3] + '</td>' +
				'<td class="' + presentation[6] + '"><span class="glyphicon glyphicon-envelope"></span></td>' +
				'<td class="col-sm-1">' + presentation[1] + '</td>' +
				'<td class="col-sm-2">' + presentation[5] + '</td>');
	});
}

function queryParameter(key) {
    key = key.replace(/[*+?^$.\[\]{}()|\\\/]/g, '\\$&'); // escape RegEx meta chars
    var match = location.search.match(new RegExp('[?&]'+key+'=([^&]+)(&|$)'));
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}