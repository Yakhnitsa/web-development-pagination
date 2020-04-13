var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        currentPage: '',
        totalPages: '',
        lastPage:'',
        profiles:[]
    },
    methods:{
        async loadFirstPage(){
            const response = await axios.get('/api/profiles',{ params: { page:0 }})
            const responseData = response.data

            this.changeData(responseData)

        },
        async nextPage(){
            if(!this.lastPage){
                const response = await axios.get('/api/profiles',{ params: { page: this.currentPage + 1 }})
                this.changeData(response.data)
            }

        },
        async previousPage(){
            if(this.currentPage >0){
                const response = await axios.get('/api/profiles',{ params: { page: this.currentPage - 1 }})
                this.changeData(response.data)
            }
        },
        async loadPage(number){
            if(number >= null && number < this.totalPages){
                const response = await axios.get('/api/profiles',{ params: { page: number }})
                this.changeData(response.data)
            }

        },

        changeData(data){
            this.profiles = data.content
            this.lastPage = data.last
            this.currentPage = data.number
            this.totalPages = data.totalPages
        }

    },
    mounted(){
        this.loadFirstPage()
    }
})