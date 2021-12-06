<template>
  <div>
    <Navegacao />
    <div class="mx-auto" style="max-width: 1000px; padding: 30px">
      <h1>Adicionar novo Animal</h1>
      <b-form @submit.prevent="criarAnimal">
        <b-form-group
          id="input-group-1"
          label="Tipo do animal:"
          label-for="tipo"
        >
          <b-form-select
            id="tipo"
            v-model="form.tipo"
            :options="tipo"
            :value= null
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group
          id="input-group-3"
          label="Sexo:"
          label-for="sexo"
        >
          <b-form-select
            id="sexo"
            v-model="form.sexo"
            :options="sexo"
            :value= null
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group
          id="input-group-4"
          label="Raça:"
          label-for="raca"
        >
          <b-form-input
            id="raca"
            v-model="form.raca"
            placeholder="Digite a raça"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Cadastrar</b-button>
        <b-button type="reset" variant="danger">Limpar</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      form: {
        tipo: '',
        sexo: '',
        raca: '',
      },
      tipo: [
        { text: 'Selecione o tipo do animal', value: '' },
        'Cão',
        'Gato',
      ],
      sexo: [
        { text: 'Selecione o sexo', value: '' },
        'Macho',
        'Fêmea',
      ],
    }
  },
  
  methods: {
    criarAnimal() {
      //event.preventDefault();
      //implementar o envio do novo animal
      console.log(this.form)
      this.$bvModal.msgBoxOk('Novo animal cadastrado com sucesso', {
          title: 'Confirmation',
          size: 'sm',
          buttonSize: 'sm',
          okVariant: 'success',
          headerClass: 'p-2 border-bottom-0',
          footerClass: 'p-2 border-top-0',
          centered: true
      }).then(
        ()=>{
          this.limparCampos()
        }
      )
    },
    limparCampos() {
      this.form = {
        tipo: '',
        sexo: '',
        raca: '',
      }
    },
  },
}
</script>
