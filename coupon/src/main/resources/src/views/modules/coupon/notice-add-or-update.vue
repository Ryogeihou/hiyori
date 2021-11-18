<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="id">
      <el-input v-model="dataForm.id" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createdtime">
      <el-input v-model="dataForm.createdtime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="downloadpath">
      <el-input v-model="dataForm.downloadpath" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="path">
      <el-input v-model="dataForm.path" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sort">
      <el-input v-model="dataForm.sort" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="src">
      <el-input v-model="dataForm.src" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="type">
      <el-input v-model="dataForm.type" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="nid">
      <el-input v-model="dataForm.nid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="context">
      <el-input v-model="dataForm.context" placeholder=""></el-input>
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
          id: 0,
          id: '',
          createdtime: '',
          downloadpath: '',
          path: '',
          sort: '',
          src: '',
          status: '',
          type: '',
          nid: '',
          context: '',
          title: ''
        },
        dataRule: {
          id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createdtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          downloadpath: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          path: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          src: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          nid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          context: [
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
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/coupon/notice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.id = data.notice.id
                this.dataForm.createdtime = data.notice.createdtime
                this.dataForm.downloadpath = data.notice.downloadpath
                this.dataForm.path = data.notice.path
                this.dataForm.sort = data.notice.sort
                this.dataForm.src = data.notice.src
                this.dataForm.status = data.notice.status
                this.dataForm.type = data.notice.type
                this.dataForm.nid = data.notice.nid
                this.dataForm.context = data.notice.context
                this.dataForm.title = data.notice.title
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
              url: this.$http.adornUrl(`/coupon/notice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'id': this.dataForm.id,
                'createdtime': this.dataForm.createdtime,
                'downloadpath': this.dataForm.downloadpath,
                'path': this.dataForm.path,
                'sort': this.dataForm.sort,
                'src': this.dataForm.src,
                'status': this.dataForm.status,
                'type': this.dataForm.type,
                'nid': this.dataForm.nid,
                'context': this.dataForm.context,
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
