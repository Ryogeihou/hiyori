<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="catsecondid">
      <el-input v-model="dataForm.catsecondid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="costprice">
      <el-input v-model="dataForm.costprice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="count">
      <el-input v-model="dataForm.count" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isdelete">
      <el-input v-model="dataForm.isdelete" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="marketvalue">
      <el-input v-model="dataForm.marketvalue" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="onoffer">
      <el-input v-model="dataForm.onoffer" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point">
      <el-input v-model="dataForm.point" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="selling">
      <el-input v-model="dataForm.selling" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="suhead">
      <el-input v-model="dataForm.suhead" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="title">
      <el-input v-model="dataForm.title" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vipprice">
      <el-input v-model="dataForm.vipprice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="subhead">
      <el-input v-model="dataForm.subhead" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rhid">
      <el-input v-model="dataForm.rhid" placeholder=""></el-input>
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
          catsecondid: '',
          costprice: '',
          count: '',
          isdelete: '',
          marketvalue: '',
          onoffer: '',
          point: '',
          price: '',
          selling: '',
          suhead: '',
          title: '',
          vipprice: '',
          subhead: '',
          rhid: ''
        },
        dataRule: {
          catsecondid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          costprice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          count: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isdelete: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          marketvalue: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          onoffer: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          selling: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          suhead: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vipprice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          subhead: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rhid: [
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
              url: this.$http.adornUrl(`/product/sku/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.catsecondid = data.sku.catsecondid
                this.dataForm.costprice = data.sku.costprice
                this.dataForm.count = data.sku.count
                this.dataForm.isdelete = data.sku.isdelete
                this.dataForm.marketvalue = data.sku.marketvalue
                this.dataForm.onoffer = data.sku.onoffer
                this.dataForm.point = data.sku.point
                this.dataForm.price = data.sku.price
                this.dataForm.selling = data.sku.selling
                this.dataForm.suhead = data.sku.suhead
                this.dataForm.title = data.sku.title
                this.dataForm.vipprice = data.sku.vipprice
                this.dataForm.subhead = data.sku.subhead
                this.dataForm.rhid = data.sku.rhid
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
              url: this.$http.adornUrl(`/product/sku/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'catsecondid': this.dataForm.catsecondid,
                'costprice': this.dataForm.costprice,
                'count': this.dataForm.count,
                'isdelete': this.dataForm.isdelete,
                'marketvalue': this.dataForm.marketvalue,
                'onoffer': this.dataForm.onoffer,
                'point': this.dataForm.point,
                'price': this.dataForm.price,
                'selling': this.dataForm.selling,
                'suhead': this.dataForm.suhead,
                'title': this.dataForm.title,
                'vipprice': this.dataForm.vipprice,
                'subhead': this.dataForm.subhead,
                'rhid': this.dataForm.rhid
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
