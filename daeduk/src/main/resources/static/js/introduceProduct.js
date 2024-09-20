document.addEventListener('DOMContentLoaded', function () {
    const arrows = document.querySelectorAll('.arrow img');

    arrows.forEach(arrow => {
        arrow.addEventListener('mouseover', function () {
            arrow.style.transform = 'translateX(20px)';
        });

        arrow.addEventListener('mouseout', function () {
            arrow.style.transform = 'translateX(0)';
        });
    });
});