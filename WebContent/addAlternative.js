/**
 * 
 */
$(document).ready(function(){
	// SectionCounter and QuestionCounter respectively.
	// "section_div_" är 12 bokstäver
	// "question_div_" är 13 bokstäver
	var sC = 0; 
	var qC = 0;
	var section_id_length = 12;
	var question_id_length = 13;
	var idAttr = '';
	$('input[name="create_section"]').click(function(labelTag,inputTextTag,inputButtonTag,inputSubmitTag,divTag,sC,idAttr) {
		idAttr = $('div[id^="section_div"]').last().attr('id');
		if(idAttr == undefined){
			sC = 1;
		}else{
			sC = idAttr.slice(section_id_length);
			sC++;
		}
		//Section
		$('form').append('<div class="section" id="section_div_'+sC+'"></div>');
		var section_div = $('#section_div_'+sC);
		section_div
			.append('<div class="section_row_1" id="section_'+sC+'_row_1"></div>')
			.append('<div class="section_row_2" id="section_'+sC+'_row_2"></div>');
		//Section row 1
		var section_row_1 = $('#section_div_'+sC+' #section_'+sC+'_row_1');
		section_row_1
			.append('<label for="section_title_'+sC+'">Sektions titel '+sC+'</label>')
			.append('<input class="title" type="text" id="section_title_'+sC+'" name="section_title_'+sC+'" />')
			.append('<input type="button" name="delete_section_'+sC+'" value="Ta bort" />');
		//Section row 2
		var section_row_2 = $('#section_div_'+sC+' #section_'+sC+'_row_2');
		section_row_2
			.append('<label for="section_description_'+sC+'">Sektions beskrivning</label>')
			.append('<textarea type="text" id="section_description_'+sC+'" name="section_description_'+sC+'"></textarea>');
		
	});
	$('input[name="create_question"]').click(function(idAttr) {
		idAttr = $('div[id^="question_div_"]').last().attr('id');
		if(idAttr == undefined){
			qC = 1;
		}else{
			qC = idAttr.slice(question_id_length);
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
		
		var multiple_choice = $('<input type="checkbox" id="alternatives_'+qC+'" name="option_types_'+qC+'" value="Fasta alternativ" checked="checked" />');
		
		// Shows/hides Description of choice alternatives on change.
		// Also change the choice alternatives to editable/non-editable.
		multiple_choice.change(function() {
			var radio_scale1to6 = $(this).parent().next().find('input.scale1to6');
			var isChecked = $(this).attr('checked');
			var isRadioSelected = $(radio_scale1to6).attr('checked');
			if (isChecked) {
				$(radio_scale1to6).parent().children('input').attr('disabled','');
			} else {
				$(radio_scale1to6).parent().children('input').attr('disabled','disabled');	
			}
			if (isChecked && !isRadioSelected) {
				$(radio_scale1to6).parent().next().addClass('visible');
			} else {
				$(radio_scale1to6).parent().next().removeClass('visible');
			}
			return false;
		});
		
		question_div_fieldset
			.append('<input type="checkbox" id="mandatory_'+qC+'" name="option_types_'+qC+'" checked="checked" value="Obligatorisk"/>')
			.append('<label for="free_text_'+qC+'">Obligatorisk</label>')
			.append('<input type="checkbox" id="free_text_'+qC+'" name="option_types_'+qC+'" checked="checked" value="Fri text"/>')
			.append('<label for="free_text_'+qC+'">Fri text</label>')
			.append(multiple_choice)
			.append('<label for="alternatives_'+qC+'">Fasta alternativ</label>');
		
		//Single choice alternatives
		question_div.append('<fieldset></fieldset>');
		var single_choice_alt = $('#question_div_'+qC+' fieldset:last');
		
		var multiple_choice = $('<input type="radio" id="multiple_choice_'+qC+'" name="option_type_'+qC+'" value="Flerval" />');
		//Shows/hides Description of choice alternatives on change 
		//FIXME
//		$("input[@name='rdio']").change(function(){
//		    if ($("input[@name='rdio']:checked").val() == 'a')
//		        // Code for handling value 'a'
//		    else if ($("input[@name='rdio']:checked").val() == 'b')
//		        // Code for handling value 'b'
//		    else
//		        // Code for handling 'c'
//		});

		multiple_choice.change(function() {
			$(this).parent().next().toggleClass('visible');
			return false;
		});
		
		single_choice_alt
			.append('<input type="radio" id="single_choice_'+qC+'" name="option_type_'+qC+'" value="Enval" />')
			.append('<label for="single_choice_'+qC+'">Enval</label>')
			.append('<input type="radio" id="multiple_choice_'+qC+'" name="option_type_'+qC+'" value="Flerval" />')
			.append('<label for="multiple_choice_'+qC+'">Flerval</label>')
			.append('<input type="radio" class="scale1to6" id="scale_'+qC+'" name="option_type_'+qC+'" checked="checked" value="1-6" />')
			.append('<label for="scale_'+qC+'">1-6</label>');
		
		// Shows/hides Description of choice alternatives on change. 
		single_choice_alt.find('input').change(function() {
			var isScaleSelected = $(this).attr('checked') && $(this).hasClass('scale1to6');
			if (!isScaleSelected) {
				$(this).parent().next().addClass('visible');
			} else {
				$(this).parent().next().removeClass('visible');
			}
			return false;
		});
		
		//Description of choice alternatives
		question_div.append('<fieldset class="alt_description"><legend>Beskrivning av Alternativen</legend><ul><li></li><li></li></ul></fieldset>');
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
		//console.log($(this));
	});
	
	// Add Alternative Description
	$('input[name^="add_alt_"]').live('click',function() {
		var last_alt = $(this).prev().append('<li></li>').children().last();
		last_alt
			.append('<input type="text" id="alt_description_'+qC+'_2" name="alt_description_'+qC+'_2" />')
			.append('<input type="image" id="delete_alt_'+qC+'_2" name="delete_alt_'+qC+'_2" src="delete.jpg" alt="Ta bort" />');
		return false;
	});
	
});