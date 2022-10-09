<template>

  <div class="tab-menu">
    <TabMenu :model="items" />
    <router-view/>
  </div>
  <Toast />
</template>

<script>
export default {
  data() {
		return {
			items: [
                {label: 'Home', icon: 'pi pi-fw pi-home', to: '/'},
                {label: 'Marcas', icon: 'pi pi-tag', to: '/marca'},
                {label: 'Carros', icon: 'pi pi-car', to: '/carro'},
                {label: 'Cor', icon: 'pi pi-palette', to: '/cor'},
                {label: 'About', icon: 'pi pi-prime', to: '/about'}
            ]
		}
	}
}
</script>

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