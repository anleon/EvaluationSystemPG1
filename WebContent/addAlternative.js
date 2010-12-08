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
		var section_div = $('#section_div_'+sC);
		section_div
			.append('<label for="section_title_'+sC+'">Sektions titel '+sC+'</label>')
			.append('<input type="text" id="section_title_'+sC+'" name="section_title_'+sC+'" />')
			.append('<input type="button" name="delete_section_'+sC+'" value="Ta bort" />')
			.append('<label for="section_description_'+sC+'">Sektions beskrivning</label>')
			.append('<textarea type="text" id="section_description_'+sC+'" name="section_description_'+sC+'"></textarea>');
		
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
		var question_div = $('#question_div_'+qC);
		question_div
			.append('<h4><label for="question_'+qC+'">Fråga '+qC+':</label></h4>')
			.append('<textarea type="text" id="question_'+qC+'" name="question_'+qC+'"></textarea>')
			.append('<input type="button" name="delete_question_'+qC+'" value="Ta bort" />')
		//Multiple choice alternatives
			.append('<fieldset></fieldset>');
		var question_div_fieldset = $('#question_div_'+qC+' fieldset');
		question_div_fieldset
			.append('<input type="checkbox" id="free_text_'+qC+'" name="option_types_'+qC+'" checked="checked" />')
			.append('<label for="free_text_'+qC+'">Fri text</label>')
			.append('<input type="checkbox" id="alternatives_'+qC+'" name="option_types_'+qC+'" checked="checked" />')
			.append('<label for="alternatives_'+qC+'">Fritext</label>');
		
		//Single choice alternatives
		question_div.append('<fieldset></fieldset>');
		var single_choice_alt = $('#question_div_'+qC+' fieldset:last');
		single_choice_alt
			.append('<input type="radio" id="single_choice_'+qC+'" name="option_type_'+qC+'" value="Enval" />')
			.append('<label for="single_choice_'+qC+'">Enval</label>')
			.append('<input type="radio" id="multiple_choice_'+qC+'" name="option_type_'+qC+'" value="Flerval" />')
			.append('<label for="multiple_choice_'+qC+'">Flerval</label>')
			.append('<input type="radio" id="scale_'+qC+'" name="option_type_'+qC+'" checked="checked" value="1-6" />')
			.append('<label for="scale_'+qC+'">1-6</label>');
		
		//Description of choice alternatives
		question_div.append('<h5>Beskrivning av Alternativen</h5><fieldset><ul><li></li><li></li></ul></fieldset>');
		var first_alt_description = $('#question_div_'+qC+' fieldset:last li:first');
		first_alt_description
			.append('<input type="text" id="alt_description_'+qC+'_1" name="alt_description_'+qC+'_1" />')
			.append('<input type="image" id="delete_alt_'+qC+'_1" name="delete_alt_'+qC+'_1" src="delete.jpg" alt="Ta bort" />');
		var last_alt_description = $('#question_div_'+qC+' fieldset:last li:last');
		last_alt_description
			.append('<input type="text" id="alt_description_'+qC+'_2" name="alt_description_'+qC+'_2" />')
			.append('<input type="image" id="delete_alt_'+qC+'_2" name="delete_alt_'+qC+'_2" src="delete.jpg" alt="Ta bort" />');
		
		$('#question_div_'+qC+' fieldset:last').append('<input type="image" id="add_alt_'+qC+'" name="add_alt_'+qC+'" src="add.jpg" alt="Lägg till" />');
	});
	
	// Delete Alternative Description
	$('input[name^="delete_"]').live('click',function() {
		$(this).parent().remove();
		console.log($(this));
	});
	
	// Add Alternative Description
	$('input[name^="add_alt_"]').live('click',function() {
		var last_alt = $(this).prev().append('<li></li>').children().last();
		last_alt
			.append('<input type="text" id="alt_description_'+qC+'_2" name="alt_description_'+qC+'_2" />')
			.append('<input type="image" id="delete_alt_'+qC+'_2" name="delete_alt_'+qC+'_2" src="delete.jpg" alt="Ta bort" />');
		
	});
	
});