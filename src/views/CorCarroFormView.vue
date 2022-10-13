<template>
<div class="corpo">
    <div class="container">
        <div class="header">
            <h2>Cadastro de cores</h2>
        </div>

        <form id="form" class="form" @submit.prevent="salvar()">
            <div class="form-control">
                <label for="nome"  >Nome da cor </label>
                <InputText type="text" v-model="cor.nome"/>
            </div>
            <div class="form-control">
                <label for="rgb" >RGB </label>
                <InputText type="text" v-model="cor.rgb"/>
            </div>
            <div class="form-control-checkbox">
                <Checkbox v-model="cor.ativo" :binary="true" />
                <label for="ativo" > Ativo</label>
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
            cor: {
                nome:'',
                rgb:'',
                ativo:''
            },
            mensagem: null
        }
    },
    mounted() {
        const id = this.$route.params.id
        if (id) {
            axios.get(`https://carros-app-example.herokuapp.com/cor/${id}`)
            .then(resp => this.cor = resp.data)
            .catch(error => {
                alert(error)
                this.$router.push("/cor")
            })
        }
        else {
            this.cor = {
                id:null,
                nome:'',
                rgb:'',
                ativo:false
            }
        }
    },
    methods: {
        salvar() {
            axios.post('https://carros-app-example.herokuapp.com/cor', this.cor)
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

.form {
  padding: 20px;
}

.form-control {
  margin-bottom: 5px;
  padding-bottom: 20px;
  position: relative;
}

.form-control-checkbox {
  margin-bottom: 30px;
  position: relative;
}

.form-control label {
  display: inline-block;
  margin-bottom: 10px;
}

.form .p-inputtext {
  border: 2px solid #f0f0f0;
  display: block;
  border-radius: 10px;
  font-size: 14px;
  width: 100%;
  padding: 10px;
}

.form .p-button {
  font-size: 14px;
  width: 100%;
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 5px;
}
</style>