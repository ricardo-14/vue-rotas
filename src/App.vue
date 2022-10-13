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
                {label: 'Cores', icon: 'pi pi-palette', to: '/cor'},
                {label: 'Carros', icon: 'pi pi-car', to: '/carro'},
                {label: 'About', icon: 'pi pi-prime', to: '/about'}
            ]
		}
	}
}
</script>

<style>

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: "Poppins", sans-serif;
}

</style>