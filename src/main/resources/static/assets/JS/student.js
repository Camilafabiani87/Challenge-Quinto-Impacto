const app = Vue.createApp({
  data() {
    return {
      cursos: [],
      nombre: "",
      edad: 0,
      fechaNacimiento: "",
      alumno: {},
      borrarAlumno: "",
      url: "/api/courses",
      cursoOk:{}
    };
  },

  created() {
    axios
      .get("/api/student/current")
      .then((response) => {
        this.alumno = response.data;
        console.log(this.alumno);
      })
      .catch(function (error) {
        console.log(error);
      });
      axios.get(this.url)
      .then((response) => {
        this.cursos = response.data;
        console.log(this.cursos);
      })
      .catch(function (error) {
        console.log(error);
      });
  },
  methods: {
    inscribir() {
      Swal.fire({
        title: "¿Seguro quieres inscribirte en este Curso?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, inscribirme!",
      }).then((result) => {
        if (result.isConfirmed) {
          axios
            .post(
              "/api/courses",
              this.cursoOk
            )
            .then(
              Swal.fire(
                "Inscripto!",
                "Has sido inscripto con éxito!",
                "success"
              ).then((response) => window.location.reload())
            );
        }
      });
    },
  },

  borrarAlumno() {
    axios
      .delete("/api/student", `name=${this.borrarAlumno}`)
      .then((x) => window.location.reload())
      .catch((response) =>
        Swal.fire({
          icon: "error",
          title: "Oops..!",
          text: "Algún dato es incorrecto!",
        })
      );
  },
})
.mount("#app");
