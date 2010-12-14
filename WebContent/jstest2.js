// Simpelt skript som populerar en utvärdering
//NOTE 'click' verkar inte trigga funktionen som ändrar i css:en. Varför?
// Tanke är att göra om den så att den tar argument, 
// fullösning/demolösning att göra så att den kollar på en body-id och populerar efter den.
// Detta är tänkt som ett test. 
// Vi hade tänkt använda det även som en demovisning-trick.
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

	function populate(eval) {
	
		$('input#title').attr('value',eval.title);
		$('input#group option').eq(eval.group).attr('selected',"selected");
		
		$.each(eval.eval_component, function(key,value){
			
			if (value.type == "section") {
				
				var section = value;
				$('input[name="create_section"]').click();
				$('div.section:last input.title').attr('value',section.title);
				$('div.section:last textarea').attr('value',section.description);
				
			} else if (value.type == "question") {
				
				var question = value;
				$('input[name="create_question"]').click();
				$('div.question:last textarea').attr('value',question.description);
				
				// default is true, btw...
				if (question.mandatory === false) {
					$('div.question:last input[id^="mandatory_"]').click();
				}
				// undefined is a bitch... use type safety to protect yourself...
				if (question.options.freetext === false) {
					$('div.question:last input[id^="free_text_"]').click();
				}
				// Det här är annars ett objekt...
				if (question.options.choice_set === false) {
					$('div.question:last input[id^="alternatives_"]').click();
				}
			
				
				if (question.options.choice != null) {
					var choice = null;
					if (question.options.choice.single_choice != undefined) {
						$('div.question:last input[id^="single_choice_"]').click();
						choice = question.options.choice.single_choice;
					}
					if (question.options.choice.multiple_choice != undefined) {
						$('div.question:last input[id^="multiple_choice_"]').click();
						choice = question.options.choice.multiple_choice;
					}
					if (question.options.choice.scale != undefined) {
						$('div.question:last input[id^="scale_"]').click();
					}
					
					if (question.options.choice.single_choice != undefined || question.options.choice.multiple_choice != undefined) {
						
						$.each(choice.alternatives, function(index,item){
							if (index >= 2) {
								$('div.question:last input[name^="add_alt_"]').click();
							}
							$('div.question:last .alt_description input[type="text"]').eq(index).attr('value',item);
						});
						
					}
				}
			}
			
		});	
	}