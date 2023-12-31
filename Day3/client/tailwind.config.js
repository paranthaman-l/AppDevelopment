/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors:{
      "blue": "#2998FF",
      "hoverBlue": "#007ef3",
      "gray": "#d9d9d9",
      "darkGray": "#35393a",
      "inputErrorRed": "#d0021b",
      },
      fontFamily:{
        "poppins":'Poppins',
        "alata":'Alata',
        "montserrat":'Montserrat',
      }
    },
  },
  plugins: [],
}