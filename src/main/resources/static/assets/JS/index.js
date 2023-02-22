const app = Vue.createApp({
  data() {
    return {
      cursos: [],
    };
  },

  created() {
    axios
      .get("/api/course")
      .then((response) => {
        this.cursos = response.data;
        console.log(this.cursos);
      })
      .catch(function (error) {
        console.log(error);
      });
  },
  methods: {},
})
.mount("#app");
