<template>
	<view>

		<view @click="onClick">标题:{{title}}</view>
		<input type="text" v-model="title" />
		<view>原标题 {{title}}</view>
		<view>原标题 {{changeTitle}}</view>

		<view>--------------------v-form----------------</view>
		<form @submit="onSubmit1">
			<view class="row1">
				<input type="text" name="username" />
			</view>
			<view class="row1">
				<textarea name="content" />
			</view>
			<view class="row1">
				<button type="primary" form-type="submit">提交表单</button>
				<button form-type="reset">重置表单</button>
			</view>
			<view class="row1">
				<radio-group name="gender">
					<radio value="男">男</radio>
					<radio value="女">女</radio>
					<radio value="保密" checked="true">保密</radio>
				</radio-group>
			</view>
			<view class="row1">
				<picker :range="options" name="sch" :value="selectValue" @change="perChange">
					<view>点击选择学历:{{options[selectValue]}}</view>
				</picker>
			</view>
			{{msg}}
		</form>

		<view>--------------------v-model----------------</view>
		<view class="out">
			<view class="row">
				<input class="border" type="text" placeholder="请输入用户名" v-model="message.username" />
			</view>
			<view class="row">
				<input class="border" type="text" placeholder="请输入手机号" v-model="message.userPhone" />
			</view>
			<view class="row">
				<textarea class="border" placeholder="请输入内容" v-model="message.content"></textarea>
			</view>
			<view class="row">
				<button type="primary" @click="onSubmit">提交</button>
			</view>
			{{message}}
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: "UniApp学习测试",
				message: {
					username: "",
					userPhone: "",
					content: ""
				},
				msg: null,
				options: ["博士", "硕士", "本科", "高中", "中学"],
				selectValue: 2
			};
		},
		methods: {
			onClick() {
				this.title = Math.random()
			},
			onSubmit() {
				console.log(this.message)
			},
			onSubmit1(e) {
				this.msg = e.detail.value
			},
			perChange(e) {
				this.selectValue = e.detail.value
			}
		},
		computed: {
			demo() {
				return this.msg + " UniApp学习"
			},
			changeTitle() {
				return this.title.toLocaleUpperCase();
			}
		}
	}
</script>

<style lang="scss">
	input,
	textarea {
		border: 1px solid #eee;
	}

	.row1 {
		padding: 20rpx;
	}

	.out {
		padding: 30rpx;

		.row {
			margin-bottom: 10rpx;
		}

		.border {
			border: 1px solid #eee;
			width: 100%;
			min-height: 80rpx;
			box-sizing: border-box
		}
	}
</style>