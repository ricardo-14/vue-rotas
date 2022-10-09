<template>
  <div>
    <h1>Cor dos carros</h1>
    <DataTable :value="cores">
        <Column field="id" header="ID"></Column>
        <Column field="nome" header="Nome"></Column>
        <Column field="rgb" header="RGB"></Column>
        <Column field="ativo" header="Ativos"></Column>   
    </DataTable>
    <br>
    <Button class="button-cor" label="Nova cor" icon="pi pi-plus" iconPos="left" @click="novo()"/>
  </div><br>

  <div>  
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
.button-cor {
    float: right;
}
</style>