<template>
    <div>
        <Navegacao/>
        <div class="mx-auto" style="max-width: 1000px">
          <h1>Animais em lares temporários</h1>
          <b-table striped responsive hover :items = "animais" :fields="fields">

            <template #cell(raca)="data">
              <NuxtLink :to="`/animais/${data.value}`">
                <span>{{data.value}}</span>
              </NuxtLink>
            </template>

          </b-table>
      </div>
    </div>
</template>

<script>
export default {
    async asyncData({$axios}){
        let data;
        try{
        data = await $axios.$get("/animais");
        } catch(e){ //trata o erro se houver
        console.log(e);
        }
        console.log(JSON.stringify(data));
        return {data};
      },
        data: function(){
            return {
              fields:[
                {
                  key: "tipoAnimal"
                },
                {
                  key: "sexo"
                },
                {
                  key: "raca"
                },
              ]
              //animais:[
                //{tipoAnimal:"cão", nome:"Totó", sexo: "macho", raca:"raça não definida"},
                //{tipoAnimal:"gato", nome:"Lili", sexo: "fêmea", raca:"Siamês"},
                //{tipoAnimal:"gato", nome:"Arnold", sexo: "macho", raca:"Himalaio"},
                //{tipoAnimal:"cão", nome:"Bela", sexo: "fêmea", raca:"Golden retriever"}
              //]
            }
        }
    }
</script>
