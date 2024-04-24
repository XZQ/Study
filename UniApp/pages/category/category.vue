<template>
	<view>
		<view>{{username}}</view>
		<view>{{obj.age}}</view>
		<view v-if="state">uniapp学习</view>
		<view v-else>学习有个毛用</view>
		<view>--------------------v-if-----------------</view>
		<view v-if="type === 'B'">B</view>
		<view v-else-if="type === 'A'">A</view>
		<view v-else-if="type === 'C'">Cs</view>
		<view v-else>D</view>
		<view>--------------------v-show-----------------</view>
		<view v-show="state">D</view>
		<view v-show="!state">D</view>

		<view>--------------------v-for-----------------</view>
		<view v-for="(item,index) in arr" class="out" :key="item.toString()">
			<view class="row">{{index+" "+item}}</view>
		</view>
		<view v-for="(value,name,index) in obj">
			{{index}} {{name}} {{value}}
		</view>
		<view>--------------------v-html-----------------</view>
		<view v-html="code"></view>

		<view>--------------------v-on:click-----------------</view>
		<view v-on:click="onClick">{{username}}</view>
		<button @click="clickNum">{{num}}</button>
		<view>--------------------v-for-----------------</view>
		<view class="nav">
			<view class="item" :class="navIndex==index?'active':''" v-for="(item,index) in newArr" :key="item.id"
				@click="clickNav(index)">
				{{item.title}}
			</view>
		</view>

		<view>--------------------v-bind-----------------</view>
		<!-- <view class="box" v-bind:style="'background:blue'"> </view> -->
		<!-- <view class="box" style="{background:''blue'}"> </view> -->
		<view class="box" v-bind:style="{background:bgcolor}" @click="clickBg"> </view>
		<view class="block" :class="{myactive:state}" @click="clickBlock"></view>
		<view class="block" :class="state ? 'myactive' : ''"></view>
		<view>--------------------v-bind-----------------</view>
		<image class="iamge" v-bind:src="'../../static/list/pic'+item+'.jpg'" v-for="item in [1,2,3]" mode="aspectFills"></image>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				img: "../../static/list/pic4.jpg",
				username: "XZQ",
				bgcolor: "pink",
				num: 1,
				obj: {
					name: "张三",
					age: 22,
					id: 1
				},
				state: false,
				type: 'B',
				arr: ["aaa", "bbb", "ccc", 111, 222, 333],
				code: "<h2>Uniapp学习</h2><em>Uniapp教程</em>",
				newArr: [{
						id: 1,
						title: "首页"
					},
					{
						id: 2,
						title: "教程"
					},
					{
						id: 3,
						title: "学习"
					},
					{
						id: 4,
						title: "关于"
					}
				],
				navIndex: 0
			};
		},
		methods: {
			onClick: function() {
				this.username = "Google"
			},
			clickNum: function() {
				this.num++;
			},
			clickBg() {
				let color = "#" + String(Math.random()).substr(3, 6)
				this.bgcolor = color
			},
			clickBlock() {
				this.state = !this.state
			},
			clickNav(e) {
				this.navIndex = e
			}
		},
		onLoad() {},
	}
</script>

<style lang="scss">
	.iamge{
		width: 100%;
		height: 400rpx;
	}
	.nav {
		display: flex;
		justify-content: space-around;
		align-items: center;

		.item {
			flex: 1;
			line-height: 90rpx;
			background: #ccc;
			text-align: center;
			// &.active {
			// 	background: green;
			// 	color: white;
			// }
		}

		.item.active {
			background: green;
			color: white;
		}
	}

	.box {
		width: 200rpx;
		height: 200rpx;
		background: pink;
	}

	.out {
		.row {
			font-size: 50rpx;
			border-bottom: 1px solid palegreen;
			width: 200rpx;
		}
	}

	.block {
		width: 400rpx;
		height: 400rpx;
		background: cyan;
	}

	.myactive {
		width: 400rpx;
		height: 400rpx;
		background: mediumseagreen;
		border-radius: 20rpx;
	}
</style>