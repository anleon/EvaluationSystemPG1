/**
 * 
 */
$(document).ready(function(){
//	var labelTag = '<label></label>';
//	var inputTextTag = '<input type="text" />';
//	var inputButtonTag = '<input type="button" />';
//	var inputSubmitTag = '<input type="submit" />';
//	var inputCheckboxTag = '<input type="checkbox" />';
//	var inputRadioTag = '<input type="radio" />';
//	var divTag = '<div></div>';
	var sectionCounter = 0;
	var questionCounter = 0;
	var idAttr = '';
	$('input[name="create_section"]').click(function(labelTag,inputTextTag,inputButtonTag,inputSubmitTag,divTag,sectionCounter,idAttr) {
		idAttr = $('div[id^="section_div"]').last().attr('id');
		if(idAttr == undefined){
			sectionCounter = 1;
		}else{
			sectionCounter = idAttr.slice(12);
			sectionCounter++;
		}
		//console.log(sectionCounter);
		$('form').append('<div class="section" id="section_div_'+sectionCounter+'"></div>');
		$('#section_div_'+sectionCounter).append('<label for="section_title_'+sectionCounter+'">Sektions titel '+sectionCounter+'</label>');
		$('#section_div_'+sectionCounter).append('<input type="text" id="section_title_'+sectionCounter+'" name="section_title_'+sectionCounter+'" />');
		$('#section_div_'+sectionCounter).append('<input type="submit" name="delete_section_'+sectionCounter+'" value="Ta bort" />');
		$('#section_div_'+sectionCounter).append('<label for="section_description_'+sectionCounter+'">Sektions beskrivning</label>');
		$('#section_div_'+sectionCounter).append('<textarea type="text" id="section_description_'+sectionCounter+'" name="section_description_'+sectionCounter+'"></textarea>');
		
	});
	$('input[name="create_question"]').click(function(idAttr) {
		idAttr = $('div[id^="question_div_"]').last().attr('id');
		if(idAttr == undefined){
			questionCounter = 1;
		}else{
			questionCounter = idAttr.slice(13);
			questionCounter++;
		}
		//console.log(this);
		$('form').append('<div class="question" id="question_div_'+questionCounter+'"></div>');
		$('#question_div_'+questionCounter).append('<label for="question_'+questionCounter+'"><h4>Fråga '+questionCounter+':</h4></label>');
		$('#question_div_'+questionCounter).append('<textarea type="text" id="question_'+questionCounter+'" name="question_'+questionCounter+'"></textarea>');
		$('#question_div_'+questionCounter).append('<input type="submit" name="delete_question_'+questionCounter+'" value="Ta bort" />');
		$('#question_div_'+questionCounter).append('<fieldset></fieldset>');
		$('#question_div_'+questionCounter+' fieldset').append('<input type="checkbox" id="free_text_'+questionCounter+'" name="option_types_'+questionCounter+'" checked="checked" />');
		$('#question_div_'+questionCounter+' fieldset').append('<label for="free_text_'+questionCounter+'">Fri text</label>');
		$('#question_div_'+questionCounter+' fieldset').append('<input type="checkbox" id="alternatives_'+questionCounter+'" name="option_types_'+questionCounter+'" checked="checked" />');
		$('#question_div_'+questionCounter+' fieldset').append('<label for="alternatives_'+questionCounter+'">Fritext</label>');
		$('#question_div_'+questionCounter).append('<fieldset></fieldset>');
		$('#question_div_'+questionCounter+' fieldset:last').append('<input type="radio" id="single_choice_'+questionCounter+'" name="option_type_'+questionCounter+'" value="Enval" />');
		$('#question_div_'+questionCounter+' fieldset:last').append('<label for="single_choice_'+questionCounter+'">Enval</label>');
		$('#question_div_'+questionCounter+' fieldset:last').append('<input type="radio" id="multiple_choice_'+questionCounter+'" name="option_type_'+questionCounter+'" value="Flerval" />');
		$('#question_div_'+questionCounter+' fieldset:last').append('<label for="multiple_choice_'+questionCounter+'">Flerval</label>');
		$('#question_div_'+questionCounter+' fieldset:last').append('<input type="radio" id="scale_'+questionCounter+'" name="option_type_'+questionCounter+'" checked="checked" value="1-6" />');
		$('#question_div_'+questionCounter+' fieldset:last').append('<label for="scale_'+questionCounter+'">1-6</label>');
		
	});
});