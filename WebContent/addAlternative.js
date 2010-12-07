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
	var idAttr = '';
	$('input[name="create_section"]').click(function(labelTag,inputTextTag,inputButtonTag,inputSubmitTag,divTag,sectionCounter,idAttr) {
		idAttr = $('div[id^="section_div"]').last().attr('id');
		if(idAttr == undefined){
			sectionCounter = 1;
		}else{
			sectionCounter = idAttr.slice(11);
			sectionCounter++;
		}
		console.log(sectionCounter);
		$('form').append('<div id="section_div'+sectionCounter+'"></div>');
		$('form #section_div'+sectionCounter).append('<label for="section_title'+sectionCounter+'">Sektions titel '+sectionCounter+'</label>');
		$('form #section_div'+sectionCounter).append('<input type="text" id="section_title'+sectionCounter+'" name="section_title'+sectionCounter+'" />');
		$('form #section_div'+sectionCounter).append('<input type="submit" name="delete_section'+sectionCounter+'" value="Ta bort" />');
		$('form #section_div'+sectionCounter).append('<label for="section_description'+sectionCounter+'">Sektions beskrivning</label>');
		$('form #section_div'+sectionCounter).append('<input type="text" id="section_description'+sectionCounter+'" name="section_description'+sectionCounter+'" />');
		
//		labelTag = $(labelTag).attr('for','section_title"+sectionCounter+"').text('Sektions titel "+sectionCounter+"');
		//$(inputTextTag).attr();
		//$(divTag).append(labelTag);
//		$('form').append('<div id="section_div'+sectionCounter+'"><label for="section_title">Sektions titel'+sectionCounter+'</label><input type="text" id="section_title" name="section_title" /><input type="submit" name="delete_section" value="Ta bort" /><label for="section_description">Sektions beskrivning</label><input type="text" id="section_description" name="section_description" /></div>');
	});
	$('input[name="create_question"]').click(function(idAttr) {
		idAttr = $('div[id^="question_div"]').last().attr('id');
		if(idAttr == undefined){
			questionCounter = 1;
		}else{
			questionCounter = idAttr.slice(12);
			questionCounter++;
		}
		//console.log(this);
		$('form').append('<div id="question_div'+questionCounter+'"><label for="question'+questionCounter+'">Fråga '+questionCounter+':</label><input type="text" id="question'+questionCounter+'" name="question'+questionCounter+'" /><input type="submit" name="delete_question'+questionCounter+'" value="Ta bort" /><input type="checkbox" id="question_chbx_freetext'+questionCounter+'" name="question_chbx_freetext'+questionCounter+'" /><label for="question_chbx_freetext'+questionCounter+'">Fritext</label></div>');
	});
});