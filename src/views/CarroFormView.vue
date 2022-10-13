<template>
<div class="corpo">
    <div class="container">
        <div class="header">
            <h2>Cadastro de Carros</h2>
        </div>

        <form id="form" class="form-carro" @submit.prevent="salvar()">
            <div class="form-control">
                <label for="nome">Nome </label>
                <InputText type="text" v-model="carro.nome"/>
            </div>
            <div class="form-control">
                <label for="">Ano Fabricação </label>
                <InputText type="text" v-model="carro.anoFabricacao"/>
            </div>
            <div class="form-control">
                <label for="">Ano Modelo </label>
                <InputText type="text" v-model="carro.anoModelo"/>
            </div>
            <div class="form-control">
                <label for="">Preço </label>
                <InputText type="number" v-model="carro.preco"/>
            </div>
            <div class="form-control-dropdown">
                <label for="">Marca </label>
                <Dropdown v-model="carro.marca" :options="marcas" optionLabel="nome" placeholder="Selecione uma marca" />
            </div>
            <div class="form-control-dropdown">
                <label for="">Cor </label>
                <Dropdown v-model="carro.cor" :options="cores" optionLabel="nome" placeholder="Selecione uma cor" />
            </div>

            <Button type="submit" label="Salvar"/>
            <Button label="Voltar" class="p-button-link" @click="voltar()"/>
        </form>
    </div>
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
            axios.post('https://carros-app-example.herokuapp.com/carro', this.carro)
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
  .corpo {
    width: 100%;
    min-height: 90vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
  background-color: #fafafa;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
  width: 400px;
  max-width: 100%;
  overflow: hidden;
}

.header {
  background-color: #eee;
  padding: 20px;
}

.form-carro {
  padding: 20px;
}

.form-control {
  margin-bottom: 10px;
  padding-bottom: 20px;
  position: relative;
}

.form-control-dropdown {
  margin-bottom: 30px;
  position: relative;
  border-radius: 0;
  box-shadow: 0;
}

.form-control label {
  display: inline-block;
  margin-bottom: 10px;
}

.form-carro .p-inputtext {
 
  display: block;
  border-radius: 10px;
  font-size: 14px;
  width: 100%;
  padding: 10px;
}

.form-carro .p-button {
  font-size: 14px;
  width: 100%;
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 5px;
}

.form-carro .p-dropdown {
    margin-top: 10px;
    width: 100%;
    border: 0;
}
</style>

  