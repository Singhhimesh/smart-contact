document.addEventListener('DOMContentLoaded', () => {
    const currentTheme = getCurrentTheme();
    
    document.documentElement.classList.add(currentTheme);
});

document.getElementById("theme-toggler").addEventListener("click", () => {
    let currentTheme = getCurrentTheme();
    
    let newTheme = currentTheme === "light" ? "dark" : "light";
    
    document.documentElement.classList.remove(currentTheme);
    
    document.documentElement.classList.add(newTheme);
    
    setTheme(newTheme);
});

function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

function getCurrentTheme() {
    return localStorage.getItem("theme") ?? "light";
}
