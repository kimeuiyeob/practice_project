window.addEventListener('scroll', function () {
    var sidebar = document.getElementById('sidebar');
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    var viewportHeight = window.innerHeight;
    sidebar.style.top = (scrollTop + viewportHeight * 0.25) + 'px';
});