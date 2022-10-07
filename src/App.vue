<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/marca">Marcas</router-link> |
    <router-link to="/carro">Carros</router-link> |
    <router-link to="/cor">Cor</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <div class="content">
    <router-view/>
  </div>  
</template>

<style>
.content {
  border: 1px solid silver;
}  
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>