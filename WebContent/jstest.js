// Simpelt skript som populerar en utvärdering
//NOTE 'click' verkar inte trigga funktionen som ändrar i css:en. Varför?
// Tanke är att göra om den så att den tar argument, 
// fullösning/demolösning att göra så att den kollar på en body-id och populerar efter den.
// Detta är tänkt som ett test. 
// Vi hade tänkt använda det även som en demovisning-trick.

$(document).ready( function () {
	
	$('input#title').attr('value',"En fin titel");
	$('input#group option:first').attr('selected',"selected");
	
	counter = 1;
	
	$('input[name="create_section"]').click();
	$('div.section:last input.title').attr('value',"Fin Sektionstitel");
	$('div.section:last textarea').attr('value',"En mycket fin beskrivning för den här sektionen av frågor");
	
	// Standardfråga
	$('input[name="create_question"]').click();
	$('div.question:last textarea').attr('value',"AA textOption och radiobutton1to6");
	
	// Fråga med flerval utan textsvar.
	$('input[name="create_question"]').click();
	$('div.question:last textarea').attr('value',"BBBBBBBBBBBBBBBBB");
	$('div.question:last input[id^="free_text_"]').click();
	
	$('div.question:last input[id^="single_choice_"]').click();
	$('div.question:last input[id^="alternatives_"]').click();
	$('div.question:last input[id^="alternatives_"]').click();		
	$('div.question:last input[name^="add_alt_"]').click();
	$('div.question:last input[name^="add_alt_"]').click();
	$('div.question:last .alt_description input[type="text"]:eq(0)').attr('value',"dåligt");
	$('div.question:last .alt_description input[type="text"]:eq(1)').attr('value',"ok");
	$('div.question:last .alt_description input[type="text"]:eq(2)').attr('value',"bra");
	$('div.question:last .alt_description input[type="text"]:eq(3)').attr('value',"utmärkt");
	
	//Fråga med checkbox och ej obligatorisk
	$('input[name="create_question"]').click();
	$('div.question:last textarea').attr('value',"CCCCCCCCCCCCCCCCCCCC");
	$('div.question:last input[id^="mandatory_"]').click();
	$('div.question:last input[id^="free_text_"]').click();
	$('div.question:last input[id^="multiple_choice_"]').click();
	
	$('div.question:last input[name^="add_alt_"]').click();
	$('div.question:last .alt_description input[type="text"]:eq(0)').attr('value',"utåtriktad");
	$('div.question:last .alt_description input[type="text"]:eq(1)').attr('value',"glad");
	$('div.question:last .alt_description input[type="text"]:eq(2)').attr('value',"målfokuserad");

	//Fråga textopt ingen multioption, ej obligatorisk
	$('input[name="create_question"]').click();
	$('div.question:last textarea').attr('value',"DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
	$('div.question:last input[id^="mandatory_"]').click();
	$('div.question:last input[id^="alternatives_"]').click();
	$('div.question:last input[id^="multiple_choice_"]').click();
	
	/*
	 
	#title
	#group
	
	create_section
	create_question
	
	#^ mandatory_
	#^ free_text_
	#^ alternatives_
	
	#^ single_choice_
	#^ multiple_choice_
	#^ scale_

	.alt_description
	
	^ add_alt_
	
	*/
});