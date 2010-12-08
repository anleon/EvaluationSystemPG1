/**
 * 
 */
$(document).ready(function(){
	var sC = 0;
	var qC = 0;
	var idAttr = '';
	$('input[name="create_section"]').click(function(labelTag,inputTextTag,inputButtonTag,inputSubmitTag,divTag,sC,idAttr) {
		idAttr = $('div[id^="section_div"]').last().attr('id');
		if(idAttr == undefined){
			sC = 1;
		}else{
			sC = idAttr.slice(12);
			sC++;
		}
		//Section
		$('form').append('<div class="section" id="section_div_'+sC+'"></div>');
		
		$('#section_div_'+sC).append('<label for="section_title_'+sC+'">Sektions titel '+sC+'</label>');
		$('#section_div_'+sC).append('<input type="text" id="section_title_'+sC+'" name="section_title_'+sC+'" />');
		
		$('#section_div_'+sC).append('<input type="submit" name="delete_section_'+sC+'" value="Ta bort" />');
		$('#section_div_'+sC).append('<label for="section_description_'+sC+'">Sektions beskrivning</label>');
		
		$('#section_div_'+sC).append('<textarea type="text" id="section_description_'+sC+'" name="section_description_'+sC+'"></textarea>');
		
	});
	$('input[name="create_question"]').click(function(idAttr) {
		idAttr = $('div[id^="question_div_"]').last().attr('id');
		if(idAttr == undefined){
			qC = 1;
		}else{
			qC = idAttr.slice(13);
			qC++;
		}
		//Question
		$('form').append('<div class="question" id="question_div_'+qC+'"></div>');
		
		$('#question_div_'+qC).append('<label for="question_'+qC+'"><h4>Fråga '+qC+':</h4></label>');
		$('#question_div_'+qC).append('<textarea type="text" id="question_'+qC+'" name="question_'+qC+'"></textarea>');
		
		$('#question_div_'+qC).append('<input type="submit" name="delete_question_'+qC+'" value="Ta bort" />');
		
		//Multiple choice alternatives
		$('#question_div_'+qC).append('<fieldset></fieldset>');
		
		$('#question_div_'+qC+' fieldset').append('<input type="checkbox" id="free_text_'+qC+'" name="option_types_'+qC+'" checked="checked" />');
		$('#question_div_'+qC+' fieldset').append('<label for="free_text_'+qC+'">Fri text</label>');
		
		$('#question_div_'+qC+' fieldset').append('<input type="checkbox" id="alternatives_'+qC+'" name="option_types_'+qC+'" checked="checked" />');
		$('#question_div_'+qC+' fieldset').append('<label for="alternatives_'+qC+'">Fritext</label>');
		
		//Single choice alternatives
		$('#question_div_'+qC).append('<fieldset></fieldset>');
		
		$('#question_div_'+qC+' fieldset:last').append('<input type="radio" id="single_choice_'+qC+'" name="option_type_'+qC+'" value="Enval" />');
		$('#question_div_'+qC+' fieldset:last').append('<label for="single_choice_'+qC+'">Enval</label>');
		
		$('#question_div_'+qC+' fieldset:last').append('<input type="radio" id="multiple_choice_'+qC+'" name="option_type_'+qC+'" value="Flerval" />');
		$('#question_div_'+qC+' fieldset:last').append('<label for="multiple_choice_'+qC+'">Flerval</label>');
		
		$('#question_div_'+qC+' fieldset:last').append('<input type="radio" id="scale_'+qC+'" name="option_type_'+qC+'" checked="checked" value="1-6" />');
		$('#question_div_'+qC+' fieldset:last').append('<label for="scale_'+qC+'">1-6</label>');
		
		//Description of choice alternatives
		$('#question_div_'+qC).append('<h5>Beskrivning av Alternativen</h5><fieldset><ul><li></li><li></li></ul></fieldset>');
		
		$('#question_div_'+qC+' fieldset:last li:first').append('<input type="text" id="alt_description_'+qC+'_1" name="alt_description_'+qC+'_1" />');
		$('#question_div_'+qC+' fieldset:last li:first').append('<input type="image" id="remove_alt_'+qC+'_1" name="remove_alt_'+qC+'_1" src="remove.jpg" alt="Ta bort" />');
		
		$('#question_div_'+qC+' fieldset:last li:last').append('<input type="text" id="alt_description_'+qC+'_2" name="alt_description_'+qC+'_2" />');
		$('#question_div_'+qC+' fieldset:last li:last').append('<input type="image" id="remove_alt_'+qC+'_2" name="remove_alt_'+qC+'_2" src="remove.jpg" alt="Ta bort" />');
		
		$('#question_div_'+qC+' fieldset:last').append('<input type="image" id="add_alt_'+qC+'" name="add_alt_'+qC+'" src="add.jpg" alt="Lägg till" />');
	});
});