$(document).ready(function() {
		$(".txt1").delay(500).animate({opacity : 0.8, top: 80}, 500, "swing", function() {
			$(".txt2").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing",function(){
				$(".txt3").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing",function(){
					$(".txt4").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing",function(){
						$(".txt5").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing",function(){
							$(".txt6").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing",function(){
								$(".info1").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing", function(){
									$(".info2").delay(500).animate({opacity : 0.8, top: 150}, 500, "swing");
								});
							});
						});
					});
				});
			});
		});
});