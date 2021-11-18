<template>
  <el-dialog
    :title="!dataForm.bgpic ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="brandid">
      <el-input v-model="dataForm.brandid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="count">
      <el-input v-model="dataForm.count" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="homepage">
      <el-input v-model="dataForm.homepage" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="intro">
      <el-input v-model="dataForm.intro" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="logo">
      <el-input v-model="dataForm.logo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="onsale">
      <el-input v-model="dataForm.onsale" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="slogan">
      <el-input v-model="dataForm.slogan" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="title">
      <el-input v-model="dataForm.title" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          bgpic: 0,
          brandid: '',
          count: '',
          homepage: '',
          intro: '',
          logo: '',
          onsale: '',
          slogan: '',
          title: ''
        },
        dataRule: {
          brandid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          count: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          homepage: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          intro: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          logo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          onsale: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          slogan: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.bgpic = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.bgpic) {
            this.$http({
              url: this.$http.adornUrl(`/product/brand/info/${this.dataForm.bgpic}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.brandid = data.brand.brandid
                this.dataForm.count = data.brand.count
                this.dataForm.homepage = data.brand.homepage
                this.dataForm.intro = data.brand.intro
                this.dataForm.logo = data.brand.logo
                this.dataForm.onsale = data.brand.onsale
                this.dataForm.slogan = data.brand.slogan
                this.dataForm.title = data.brand.title
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/brand/${!this.dataForm.bgpic ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'bgpic': this.dataForm.bgpic || undefined,
                'brandid': this.dataForm.brandid,
                'count': this.dataForm.count,
                'homepage': this.dataForm.homepage,
                'intro': this.dataForm.intro,
                'logo': this.dataForm.logo,
                'onsale': this.dataForm.onsale,
                'slogan': this.dataForm.slogan,
                'title': this.dataForm.title
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
