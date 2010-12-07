/**
 * 
 */
$(document).ready(function(){
	$('input[name="create_section"]').click(function() {
		//console.log(this);
		$('body').append('<label for="section_title">Sektions titel</label><input type="text" id="section_title" name="section_title" /><input type="submit" name="delete_section" value="Ta bort" /><label for="section_title">Sektions beskrivning</label><input type="text" id="section_description" name="section_description" />');
	});
	$('input[name="create_question"]').click(function() {
		//console.log(this);
		$('body').append('<label for="question">Fråga:</label><input type="text" id="question" name="question" /><input type="submit" name="delete_question" value="Ta bort" />');
	});
});