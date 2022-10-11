<template>
     <h1>Cadastro de Carros</h1>
    <div>
        <form @submit.prevent="salvar()">

        <label for="nome" id="label">Nome: </label>
        <InputText type="text" v-model="carro.nome"/><br><br>
        
        <label for="" id="label">Ano Fabricação: </label>
        <InputText type="text" v-model="carro.anoFabricacao"/><br><br>

        <label for="" id="label">Ano Modelo: </label>
        <InputText type="text" v-model="carro.anoModelo"/><br><br>
        
        <label for="" id="label">Preço: </label>
        <InputText type="number" v-model="carro.preco"/><br><br>

        <label for="" id="label">Marca: </label>
        <Dropdown v-model="carro.marca" :options="marcas" optionLabel="nome" placeholder="Selecione uma marca" /><br><br>

        <label for="" id="label">Cor: </label>
        <Dropdown v-model="carro.cor" :options="cores" optionLabel="nome" placeholder="Selecione uma cor" /><br><br>

        <Button type="submit" label="Salvar" icon="pi pi-check" iconPos="right"/><br><br>
        <a href="javascript:void(0)" @click="voltar()">Voltar</a>

        </form>

        {{carro}}
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
      data() {
          return {
              carro: {},
              marcas: [],
              cores: []
          }
      },
      mounted() {
        const id = this.$route.params.id
        if (id) {
            axios.get(`https://carros-app-example.herokuapp.com/carro/${id}`).then(resp => this.carro = resp.data)
            .catch(error => {
                alert(error)
                this.$router.push("/carro")
            })
        }
        else {
            this.carro = {}
        }
        axios
        .get('https://carros-app-example.herokuapp.com/marca')
        .then(resp => {
           this.marcas = resp.data
        })
        axios
        .get('https://carros-app-example.herokuapp.com/cor')
        .then(resp => {
           this.cores = resp.data
        })
    },
    methods: {
        salvar() {
            axios.post('https://carros-app-example.herokuapp.com/carro',  this.carro)
            .then(() => this.$toast.add({severity:'success', summary: 'Registro gravado!'}))
            .catch(error => this.$toast.add({severity:'error', summary: `Problema na gravação ${error}`}))
        },
        voltar() {
            this.$router.go(-1)
        }
    }
}

  </script>
  
  <style>
   #label {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        font-weight: bold;
    }
  </style>