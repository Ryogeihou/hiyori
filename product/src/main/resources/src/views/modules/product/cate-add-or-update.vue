<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="catIcon">
      <el-input v-model="dataForm.catIcon" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="catId">
      <el-input v-model="dataForm.catId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="catLevel">
      <el-input v-model="dataForm.catLevel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="parentid">
      <el-input v-model="dataForm.parentid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="catName">
      <el-input v-model="dataForm.catName" placeholder=""></el-input>
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
          id: 0,
          catIcon: '',
          catId: '',
          catLevel: '',
          parentid: '',
          catName: ''
        },
        dataRule: {
          catIcon: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          catId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          catLevel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          parentid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          catName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/cate/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.catIcon = data.cate.catIcon
                this.dataForm.catId = data.cate.catId
                this.dataForm.catLevel = data.cate.catLevel
                this.dataForm.parentid = data.cate.parentid
                this.dataForm.catName = data.cate.catName
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
              url: this.$http.adornUrl(`/product/cate/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'catIcon': this.dataForm.catIcon,
                'catId': this.dataForm.catId,
                'catLevel': this.dataForm.catLevel,
                'parentid': this.dataForm.parentid,
                'catName': this.dataForm.catName
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
