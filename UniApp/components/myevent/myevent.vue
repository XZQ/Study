<template>
	<view>
		{{title}}
		<view>
			<input type="text" placeholder="请输入..." @input="oninput" />
		</view>
	</view>
</template>

<script>
	export default {
		name: "myevent",
		data() {
			return {

			};
		},
		props: {
			title: String,
			default: "默认标题"
		},
		methods: {
			oninput(e) {
				this.$emit("myEnv", e.detail.value)
			}
		}
	}
</script>

<style lang="scss">

</style>