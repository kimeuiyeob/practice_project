let currentSlide = 0;
const slides = document.querySelector('.slides');
const totalSlides = document.querySelectorAll('.slide').length;

function moveSlide(direction) {
    currentSlide += direction;
    if (currentSlide < 0) {
        currentSlide = totalSlides - 1;
    } else if (currentSlide >= totalSlides) {
        currentSlide = 0;
    }
    updateSlidePosition();
}

function updateSlidePosition() {
    slides.style.transform = `translateX(-${currentSlide * 100}%)`;
}

// 자동 슬라이드 이동
setInterval(() => {
    moveSlide(1);
}, 4000);