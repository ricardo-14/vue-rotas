<template>
  <div>
    <h1>Cores dos carros</h1>
    <button @click="novo()">Novo</button>
    <table>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>RGB</th>
            <th>Ativo</th>
            <th></th>
            <th></th>
        </tr>
        <tr v-for="co in cores" :key="co.id">
            <td>{{co.id}}</td>
            <td>{{co.nome}}</td>
            <td>{{co.rgb}}</td>
            <td>{{co.ativo}}</td>
            <td><a href="javascript:void(0)" @click="editar(co)">Editar</a></td>
            <td><a href="javascript:void(0)" @click="excluir(co)">Excluir</a></td>
        </tr>
    </table>
  </div>
</template>

<script>
  import axios from 'axios';
export default {
  data() {
    return {
      cores: []
    }
  },
  methods: {
    load() {
      axios
      .get('https://carros-app-example.herokuapp.com/cor')
      .then(resp => {
        this.cores = resp.data
      })
    },
    editar(cor) {
            this.$router.push(`/cor-form/${cor.id}`)
    },
    novo() {
            this.$router.push('/cor-form/')
    },
    excluir(cor) {
            const id = cor.id
            axios
                .delete(`https://carros-app-example.herokuapp.com/cor/${id}`)
                .then(this.load())
                .catch(error => alert(error))
    },
  },
  mounted() {
    this.load()
  }

}
</script>

<style>

</style>