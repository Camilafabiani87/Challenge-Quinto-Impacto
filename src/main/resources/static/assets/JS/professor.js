const app = Vue.createApp({
  data() {
    return {
      cursos: [],
      nombre: "",
      edad: 0,
      profesor: {},
      url: "/api/courses",
      cursoOk: {},
    };
  },

  created() {
    axios
      .get("/api/professor/current")
      .then((response) => {
        this.profesor = response.data;
        console.log(this.profesor);
      })
      .catch(function (error) {
        console.log(error);
      });
    axios
      .get(this.url)
      .then((response) => {
        this.cursos = response.data;
        console.log(this.cursos);
      })
      .catch(function (error) {
        console.log(error);
      });
  },
  methods: {
    borrarCurso(curso) {
        console.log(curso);
        axios.patch("/api/deleteCourseProfessor", "name=" + curso).then(() => {
            Swal.fire({
              background: "#212121",
              confirmButtonColor: "#1bb5db",
              title: "El curso ha sido eliminado",
            }).then((x) => window.location.reload());
          });
    },
  },
  cerrarSesion() {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger",
      },
      buttonsStyling: false,
    });

    swalWithBootstrapButtons
      .fire({
        background: "#212121",
        color: "white",
        title: "¿Seguro deseas cerrar sesión?",
        // icon: 'warning',
        showCancelButton: true,
        // confirmButtonColor: '#d14334',
        // cancelButtonColor: '#d33',
        confirmButtonText: "Si",
        cancelButtonText: "No",

        reverseButtons: false,
      })
      .then((result) => {
        if (result.isConfirmed) {
          Swal.fire({
            background: "#212121",
            color: "white",
            position: "top-center",
            // icon: 'success',
            title: "Su sesión ha sido finalizada",
            showConfirmButton: false,
            timer: 10500,
          });
          axios
            .post("/api/logout")
            .then((response) => (window.location.href = "/web/index.html"));
        }
      });
  },
}).mount("#app");
