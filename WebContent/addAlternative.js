/**
 * 
 */
$(document).ready(function(){
	// counter which counts order number.
	// "section_div_" är 12 bokstäver
	// "question_div_" är 13 bokstäver 
	var counter = 3;
	console.log(counter);
	var section_id_length = 12;
	var question_id_length = 13;
	var idAttr = '';
	$('input[name="create_section"], input[name="create_question"]').click(function(counter) {
		if ($(this).is('input[name="create_section"]')){
			idAttr = $('div[id^="section_div"]').last().attr('id');
			if(idAttr == undefined){
				counter = 1;
			}else{
				counter = idAttr.slice(section_id_length);
				counter++;
			}
			//Section
			$('form').append('<div class="section" id="section_div_'+counter+'"></div>');
			var section_div = $('#section_div_'+counter);
			section_div
				.append('<div class="section_row_1" id="section_'+counter+'_row_1"></div>')
				.append('<div class="section_row_2" id="section_'+counter+'_row_2"></div>');
			//Section row 1
			var section_row_1 = $('#section_div_'+counter+' #section_'+counter+'_row_1');
			section_row_1
				.append('<label for="section_title_'+counter+'">Sektions titel</label>')
				.append('<input class="title" type="text" id="section_title_'+counter+'" name="eval_.section_ord'+counter+'_.title" />')
				.append('<input type="button" name="delete_section_'+counter+'" value="Ta bort" />');
			//Section row 2
			var section_row_2 = $('#section_div_'+counter+' #section_'+counter+'_row_2');
			section_row_2
				.append('<label for="section_description_'+counter+'">Sektions beskrivning</label>')
				.append('<textarea type="text" id="section_description_'+counter+'" name="eval_.section_ord'+counter+'_.description"></textarea>');
		}else{
			idAttr = $('div[id^="question_div_"]').last().attr('id');
			if(idAttr == undefined){
				counter = 1;
			}else{
				counter = idAttr.slice(question_id_length);
				counter++;
			}
			//Question
			$('form').append('<div class="question" id="question_div_'+counter+'"></div>');
			var question_div = $('#question_div_'+counter);
			question_div
				.append('<div class="question_row_1" id="question_'+counter+'_row_1"></div>')
				.append('<div class="question_row_2" id="question_'+counter+'_row_2"></div>')
				.append('<div class="question_row_3" id="question_'+counter+'_row_3"></div>')
				.append('<div class="question_row_4" id="question_'+counter+'_row_4"></div>');
			var question_row_1 = $('#question_div_'+counter+' #question_'+counter+'_row_1');
			question_row_1	
				.append('<h4><label for="question_'+counter+'">Fråga:</label></h4>')
				.append('<textarea type="text" id="question_'+counter+'" name="eval_.question_ord'+counter+'_.text"></textarea>')
				.append('<input type="button" name="delete_question_'+counter+'" value="Ta bort" />');
			//Multiple choice alternatives
			var question_row_2 = $('#question_div_'+counter+' #question_'+counter+'_row_2');
			question_row_2	
				.append('<fieldset></fieldset>');
			var question_row_2_fieldset = $('#question_div_'+counter+' #question_'+counter+'_row_2 fieldset');
			
			var multiple_choice = $('<input type="checkbox" id="alternatives_'+counter+'" name="option_types_'+counter+'" value="Fasta alternativ" checked="checked" />');
			
			// Shows/hides Description of choice alternatives on change.
			// Also change the choice alternatives to editable/non-editable.
			multiple_choice.change(function() {
				var radio_scale1to6 = $(this).parent().parent().next().find('fieldset input.scale1to6');
				var isChecked = $(this).attr('checked');
				var isRadioSelected = $(radio_scale1to6).attr('checked');
				if (isChecked) {
					$(radio_scale1to6).parent().children('input').attr('disabled','');
				} else {
					$(radio_scale1to6).parent().children('input').attr('disabled','disabled');	
				}
				if (isChecked && !isRadioSelected) {
					$(radio_scale1to6).parent().parent().next().addClass('visible');
				} else {
					$(radio_scale1to6).parent().parent().next().removeClass('visible');
				}
				return false;
			});
					
			question_row_2_fieldset
				.append('<input type="checkbox" id="mandatory_'+counter+'" name="option_types_'+counter+'" checked="checked" value="Obligatorisk"/>')
				.append('<label for="free_text_'+counter+'">Obligatorisk</label>')
				.append('<input type="checkbox" id="free_text_'+counter+'" name="option_types_'+counter+'" checked="checked" value="Fri text"/>')
				.append('<label for="free_text_'+counter+'">Fri text</label>')
				.append(multiple_choice)
				.append('<label for="alternatives_'+counter+'">Fasta alternativ</label>');
			
			//Single choice alternatives
			var question_row_3 = $('#question_div_'+counter+' #question_'+counter+'_row_3');
			question_row_3
				.append('<fieldset></fieldset>');
			var single_choice_alt = $('#question_div_'+counter+' #question_'+counter+'_row_3 fieldset:last');
			
//			var multiple_choice = $('<input type="radio" id="multiple_choice_'+counter+'" name="option_type_'+counter+'" value="Flerval" />');
			//Shows/hides Description of choice alternatives on change 
//			$("input[@name='rdio']").change(function(){
//			    if ($("input[@name='rdio']:checked").val() == 'a')
//			        // Code for handling value 'a'
//			    else if ($("input[@name='rdio']:checked").val() == 'b')
//			        // Code for handling value 'b'
//			    else
//			        // Code for handling 'c'
//			});

//			multiple_choice.change(function() {
//				$(this).parent().next().toggleClass('visible');
//				return false;
//			});
			
			single_choice_alt
				.append('<input type="radio" id="single_choice_'+counter+'" name="option_type_'+counter+'" value="Enval" />')
				.append('<label for="single_choice_'+counter+'">Enval</label>')
				.append('<input type="radio" id="multiple_choice_'+counter+'" name="option_type_'+counter+'" value="Flerval" />')
				.append('<label for="multiple_choice_'+counter+'">Flerval</label>')
				.append('<input type="radio" class="scale1to6" id="scale_'+counter+'" name="option_type_'+counter+'" checked="checked" value="1-6" />')
				.append('<label for="scale_'+counter+'">1-6</label>');
			
			// Shows/hides Description of choice alternatives on change. 
			single_choice_alt.find('input').change(function() {
				var isScaleSelected = $(this).attr('checked') && $(this).hasClass('scale1to6');
				if (!isScaleSelected) {
					$(this).parent().parent().next().addClass('visible');
				} else {
					$(this).parent().parent().next().removeClass('visible');
				}
				return false;
			});
			
			//Description of choice alternatives
			var question_row_4 = $('#question_div_'+counter+' #question_'+counter+'_row_4');
			question_row_4
				.append('<fieldset class="alt_description"><legend>Beskrivning av Alternativen</legend><ul><li></li><li></li></ul></fieldset>');
			var first_alt_description = $('#question_div_'+counter+' #question_'+counter+'_row_4 fieldset:last li:first');
			first_alt_description
				.append('<input type="text" id="alt_description_'+counter+'_1" name="alt_description_'+counter+'_1" />')
				.append('<input type="image" id="delete_alt_'+counter+'_1" name="delete_alt_'+counter+'_1" src="delete.png" alt="Ta bort" />');
			var last_alt_description = $('#question_div_'+counter+' #question_'+counter+'_row_4 fieldset:last li:last');
			last_alt_description
				.append('<input type="text" id="alt_description_'+counter+'_2" name="alt_description_'+counter+'_2" />')
				.append('<input type="image" id="delete_alt_'+counter+'_2" name="delete_alt_'+counter+'_2" src="delete.png" alt="Ta bort" />');
			
			$('#question_div_'+counter+' #question_'+counter+'_row_4 fieldset:last')
				.append('<input type="image" id="add_alt_'+counter+'" name="add_alt_'+counter+'" src="add.png" alt="Lägg till" />');
		
		}
		// Delete Alternative Description
		$('input[name^="delete_"]').live('click',function() {
			//FIXME
			if($(this).is('input[name^="delete_alt_"]')){
				$(this).parent().remove();
			}else{
				$(this).parent().parent().remove();
				//console.log($(this));
			}
		});
		
		// Add Alternative Description
		$('input[name^="add_alt_"]').live('click',function() {
			//FIXME
			var last_alt = $(this).prev().append('<li></li>').children().last();
			last_alt
				.append('<input type="text" id="alt_description_'+counter+'_2" name="alt_description_'+counter+'_2" />')
				.append('<input type="image" id="delete_alt_'+counter+'_2" name="delete_alt_'+counter+'_2" src="delete.png" alt="Ta bort" />');
			return false;
		});
	});
		
});