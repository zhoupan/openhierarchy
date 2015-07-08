$(function () {
	
  // Menu toggle button
  $('[data-toggle="offcanvas"]').click(function () {
    $('.row-offcanvas').toggleClass('active');
  });
  
  $(".navbar-toggle").on("click", function () {
	  $(this).toggleClass("active");
  });
});