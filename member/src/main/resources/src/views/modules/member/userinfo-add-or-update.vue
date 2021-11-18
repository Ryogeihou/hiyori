<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="id">
      <el-input v-model="dataForm.id" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="openid">
      <el-input v-model="dataForm.openid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="avatarurl">
      <el-input v-model="dataForm.avatarurl" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="brandcollection">
      <el-input v-model="dataForm.brandcollection" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="city">
      <el-input v-model="dataForm.city" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="collection">
      <el-input v-model="dataForm.collection" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="consumption">
      <el-input v-model="dataForm.consumption" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="country">
      <el-input v-model="dataForm.country" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createdtime">
      <el-input v-model="dataForm.createdtime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gender">
      <el-input v-model="dataForm.gender" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberlevel">
      <el-input v-model="dataForm.memberlevel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point">
      <el-input v-model="dataForm.point" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="province">
      <el-input v-model="dataForm.province" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="referrer">
      <el-input v-model="dataForm.referrer" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="userid">
      <el-input v-model="dataForm.userid" placeholder=""></el-input>
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
          id: '',
          openid: '',
          avatarurl: '',
          brandcollection: '',
          city: '',
          collection: '',
          consumption: '',
          country: '',
          createdtime: '',
          gender: '',
          memberlevel: '',
          mobile: '',
          nickname: '',
          point: '',
          province: '',
          referrer: '',
          userid: '',
          id: 0,
        },
        dataRule: {
          id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          openid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          avatarurl: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          brandcollection: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          collection: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          consumption: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          country: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createdtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberlevel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          referrer: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          userid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
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
              url: this.$http.adornUrl(`/member/userinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.id = data.userinfo.id
                this.dataForm.openid = data.userinfo.openid
                this.dataForm.avatarurl = data.userinfo.avatarurl
                this.dataForm.brandcollection = data.userinfo.brandcollection
                this.dataForm.city = data.userinfo.city
                this.dataForm.collection = data.userinfo.collection
                this.dataForm.consumption = data.userinfo.consumption
                this.dataForm.country = data.userinfo.country
                this.dataForm.createdtime = data.userinfo.createdtime
                this.dataForm.gender = data.userinfo.gender
                this.dataForm.memberlevel = data.userinfo.memberlevel
                this.dataForm.mobile = data.userinfo.mobile
                this.dataForm.nickname = data.userinfo.nickname
                this.dataForm.point = data.userinfo.point
                this.dataForm.province = data.userinfo.province
                this.dataForm.referrer = data.userinfo.referrer
                this.dataForm.userid = data.userinfo.userid
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
              url: this.$http.adornUrl(`/member/userinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id,
                'openid': this.dataForm.openid,
                'avatarurl': this.dataForm.avatarurl,
                'brandcollection': this.dataForm.brandcollection,
                'city': this.dataForm.city,
                'collection': this.dataForm.collection,
                'consumption': this.dataForm.consumption,
                'country': this.dataForm.country,
                'createdtime': this.dataForm.createdtime,
                'gender': this.dataForm.gender,
                'memberlevel': this.dataForm.memberlevel,
                'mobile': this.dataForm.mobile,
                'nickname': this.dataForm.nickname,
                'point': this.dataForm.point,
                'province': this.dataForm.province,
                'referrer': this.dataForm.referrer,
                'userid': this.dataForm.userid,
                'id': this.dataForm.id || undefined,
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
