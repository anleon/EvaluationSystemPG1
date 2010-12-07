/**
 * 
 */
$(document).ready(function(){
	var labelTag = '<label></label>';
	var inputTextTag = '<input type="text" />';
	var inputButtonTag = '<input type="button" />';
	var inputSubmitTag = '<input type="submit" />';
	var inputCheckboxTag = '<input type="checkbox" />';
	var inputRadioTag = '<input type="radio" />';
	var divTag = '<div></div>';
	var sectionCounter = 0;
	var questionCounter = 0;
	$('input[name="create_section"]').click(function(labelTag,inputTextTag,inputButtonTag,inputSubmitTag,divTag,sectionCounter) {
		var idAttr = $('div[id^="section_div"]').attr('id');
		sectionCounter = parsInt(idAttr);
		sectionCounter++;
		$(labelTag).attr('for','section_title"+sectionCounter+"').text('Sektions titel');
		$(inputTextTag).attr()
		$(divTag).append();
		$('form').append('<div class="section_div"><label for="section_title">Sektions titel</label><input type="text" id="section_title" name="section_title" /><input type="submit" name="delete_section" value="Ta bort" /><label for="section_title">Sektions beskrivning</label><input type="text" id="section_description" name="section_description" /></div>');
	});
	$('input[name="create_question"]').click(function() {
		var idAttr = $('div[id^="question_div"]').attr('id');
		console.log(idAttr);
		
		questionCounter = idAttr.slice(12);
		questionCounter++;
		//console.log(this);
		$('form').append('<div id="question_div'+questionCounter+'"><label for="question'+questionCounter+'">Fråga '+questionCounter+':</label><input type="text" id="question'+questionCounter+'" name="question'+questionCounter+'" /><input type="submit" name="delete_question'+questionCounter+'" value="Ta bort" /><input type="checkbox" id="question_chbx_freetext'+questionCounter+'" name="question_chbx_freetext'+questionCounter+'" /><label for="question_chbx_freetext'+questionCounter+'">Fritext</label></div>');
	});
});